package list;

import org.junit.Test;

import java.util.Stack;

/**
 * 描述
 * 输入一个长度为的链表，设链表中的元素的值为a_ia
 * i
 * ​
 *  ，输出一个链表，该输出链表包含原链表中从倒数第k个结点至尾节点的全部节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 *
 *
 * 提示:
 * 0 \leq n \leq 10^50≤n≤10
 * 5
 *
 * 0 \leq a_i \leq 10^90≤a
 * i
 * ​
 *  ≤10
 * 9
 *
 * 0 \leq k \leq 10^90≤k≤10
 * 9
 *
 *
 * 题解:利用递归的回溯
 *
 */
public class FindKthToTailSolution {
    @Test
    public  void test(){
        ListNode sortList =  ListNode.make(new int[]{1,2,3,3,4,4,5});
//        sortList.next=new ListNode(2);
//        sortList.next.next=new ListNode(3);
//        sortList.next.next.next=new ListNode(3);
//        sortList.next.next.next.next=new ListNode(4);
//        sortList.next.next.next.next.next=new ListNode(4);
        ListNode a=FindKthToTail(sortList,3);
        ListNode.printList(a);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        if(pHead==null||k==0){
            return  null;
        }
//        ListNode ph= new ListNode(-1);
//        dfs(pHead,k,ph);
//        if(ph.next!=null){
//            return  ph.next;
//        }
//        return  null;

        return getNode(pHead,k);
    }

    /**
     * 会导致栈溢出
     * @param node
     * @param k
     * @param pnode
     * @return
     */
    public int  dfs(ListNode node,int k,ListNode pnode){
        int num=0;
        if(node.next!=null){
            num=dfs(node.next,k,pnode);
        }
        num++;
        if(num==k){
            pnode.next= node;
            return  num;
        }
        return num;
    }

    /**
     * 用栈
     * @param node
     * @param k
     * @return
     */
    public ListNode getNode (ListNode node,int k){
        Stack<ListNode> stack = new Stack<>();
        int length=0;
        for(length=0;node!=null;length++){
            stack.push(node);
            node=node.next;
        }
        if(k>length){
            return  null;
        }
        for(;k!=1;k--){
            stack.pop();
        }
        return  stack.pop();
    }
}
