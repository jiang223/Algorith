package list;

import org.junit.Test;

/**
 * 描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
 *
 * 输入描述：
 * 输入分为2段，第一段是入环前的链表部分，第二段是链表环的部分，后台将这2个会组装成一个有环或者无环单链表
 * 返回值描述：
 * 返回链表的环的入口结点即可。而我们后台程序会打印这个节点
 *
 *
 * 题解：快慢指针加数学公式
 *
 *
 *
 */
public class EntryNodeOfLoopSolution {
    @Test
    public  void test(){
        ListNode sortList =  ListNode.make(new int[]{1,2,3,3,4,4,5});
//        sortList.next=new ListNode(2);
//        sortList.next.next=new ListNode(3);
//        sortList.next.next.next=new ListNode(3);
//        sortList.next.next.next.next=new ListNode(4);
//        sortList.next.next.next.next.next=new ListNode(4);

        sortList = EntryNodeOfLoop(sortList);
        ListNode.printList(sortList);

    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead==null){
            return null;
        }
        ListNode oneStepNode= pHead;
        if (pHead.next==null){
            return null;
        }
        ListNode twoStepNode= pHead;
        if ( pHead.next.next==null){
            return null;
        }
        while (true){
            twoStepNode= twoStepNode.next.next;
            oneStepNode= oneStepNode.next;
            if(oneStepNode==twoStepNode){
                twoStepNode= pHead;
                while (oneStepNode!=twoStepNode){
                    twoStepNode= twoStepNode.next;
                    oneStepNode= oneStepNode.next;

                }
                return oneStepNode;
            }
            if(twoStepNode==null){
                return  null;
            }
        }
    }
}
