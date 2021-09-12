package list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 描述
 * 输入一个链表的头节点，按链表从尾到头的顺序返回每个节点的值（用数组返回）。
 *
 * 如输入{1,2,3}的链表如下图:
 *
 * 返回一个数组为[3,2,1]
 *
 * 0 <= 链表长度 <= 10000
 *
 * 题解：
 *
 * 1、栈
 *
 *2、递归
 *
 *
 */
public class PrintListFromTailToHeadSolution {
    @Test
    public  void test(){
        ListNode sortList =  ListNode.make(new int[]{1,2,3,3,4,4,5});
//        sortList.next=new ListNode(2);
//        sortList.next.next=new ListNode(3);
//        sortList.next.next.next=new ListNode(3);
//        sortList.next.next.next.next=new ListNode(4);
//        sortList.next.next.next.next.next=new ListNode(4);

        ArrayList<Integer> list = printListFromTailToHead(sortList);
        System.out.print(list);

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode pHead) {
        if (pHead==null){
            return  new ArrayList();
        }
       //return printListFromTailToHeadBystack(pHead);//栈方式
        ArrayList<Integer> list = new ArrayList();
        printListFromTailToHeadBydfs(pHead,list);//递归方式
        return list;
    }

    public  ArrayList<Integer> printListFromTailToHeadBystack(ListNode pHead) {
        ArrayList<Integer> list = new ArrayList();
        Stack<ListNode> stack= new Stack<>();
        for(;pHead!=null;){
            stack.push(pHead);
            pHead=pHead.next;
        }
        for (;!stack.empty();){
            list.add(stack.pop().val);
        }
        return  list;
    }
    public ArrayList<Integer> printListFromTailToHeadBydfs(ListNode pHead,ArrayList<Integer> list) {
        if(pHead.next!=null){
            printListFromTailToHeadBydfs(pHead.next,list);
        }
        list.add(pHead.val);
        return list;
    }
}
