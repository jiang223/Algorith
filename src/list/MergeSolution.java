package list;

import org.junit.Test;

public class MergeSolution {
    @Test
    public  void test(){
//        ListNode sortList =  ListNode.make(new int[]{});
//        ListNode sortList2 =  ListNode.make(new int[]{});
        ListNode.printList(Merge(null,null));

    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode resultNode=new ListNode(-1);
        ListNode node= resultNode;
        for(;list1!=null||list2!=null;){
            if(list1!=null&&list2!=null){
                if(list1.val<list2.val){
                    node.next=list1;
                    list1=list1.next;
                }else {
                    node.next=list2;
                    list2=list2.next;
                }
            }else if(list1!=null){
                node.next=list1;
                list1=list1.next;
            }else {
                node.next=list2;
                list2=list2.next;
            }
            node=node.next;        }
        node.next=null;
        return  resultNode.next;


    }
}
