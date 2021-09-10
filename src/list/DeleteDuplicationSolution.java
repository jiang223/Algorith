package list;

import org.junit.Test;

public class DeleteDuplicationSolution {
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
        ListNode head = pHead;
        pHead=pHead.next;
        int  val=-1;
        ListNode nowNode=head;
        while (pHead!=null){
           if(val!=pHead.val){
               nowNode.next=pHead;
               nowNode=nowNode.next;
               val=nowNode.val;
           }else {
               nowNode.next=null;
           }
           pHead = pHead.next;
        }
        return  head;
    }
}
