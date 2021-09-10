package list;

import org.junit.Test;

public class DeleteDuplicationTwoSolution {
    @Test
    public  void test(){
        ListNode sortList =  ListNode.make(new int[]{1,2,3,3,4,4,5});
//        sortList.next=new ListNode(2);
//        sortList.next.next=new ListNode(3);
//        sortList.next.next.next=new ListNode(3);
//        sortList.next.next.next.next=new ListNode(4);
//        sortList.next.next.next.next.next=new ListNode(4);

        sortList = deleteDuplication(sortList);
        ListNode.printList(sortList);

    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode head = new ListNode(-1); // 新建一个头结点，防止链表中头结点是重复节点被删除。
        ListNode trail = head;

        while (pHead != null) {
            ListNode node = pHead.next;
            boolean flag = false;
            while (node != null && pHead.val == node.val) {
                node = node.next;
                flag = true;
            }
            if (!flag) {
                trail.next = pHead;
                trail = trail.next;
            }
            pHead = node;
        }
        trail.next = null; // 1->2->3->3->3
        return head.next;
    }
}
