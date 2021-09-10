package list;

import org.junit.Test;

import java.util.List;

class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
    public static  ListNode make(int []val){
        ListNode head =  new ListNode(val[0]);
        ListNode node = head;
        for(int i=1;i<val.length;i++){
            node.next=new ListNode(val[i]);
            node=node.next;
        }
        return  head;
    }

    public static  void printList(ListNode val){
        while (val!=null){
            System.out.print(val.val);
            val=val.next;
        }
    }
}

public class OddEvenListSolution {
    @Test
    public  void test(){
        ListNode sortList = new ListNode(1);
        sortList.next=new ListNode(2);
        sortList.next.next=new ListNode(3);
        sortList.next.next.next=new ListNode(4);

        sortList = oddEvenList(sortList);


    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList (ListNode head) {
        if(head==null) return  head;
        //无需对头节点做操作 不用dummyHead
        //奇链表头位于head 偶链表头位于head.next
        ListNode oddHead = head,evenHead = head.next;
        ListNode odd = oddHead,even = evenHead;
        //终止条件：因为even走在前面 一定先终止 所以判断条件就是它
        //节点总数为偶数个时 even.next为null
        //节点总数为奇数个时： even==null  这俩条件触发一个就跳出循环
        while (even!=null&&even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        //奇偶链表拼接
        odd.next = evenHead;
        return head;
    }
}
