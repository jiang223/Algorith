package tree;
/**

 描述：
 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。
 假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜索树）

 题解：
双指针递归，指针一指向头节点，从头开始遍历，遇到比末尾节点小的数则前进，
 指针二从倒数第二个往前遍历，遇到比末尾节点大的数则后退。
 当最后两指针相遇则分开数组，进入下一次的递归遍历。


 *  */
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class VerifySquenceOfBSTSoulution {//TODO
    @Test
    public  void test(){
        System.out.print(VerifySquenceOfBST(new int[]{8,4,6,12,16,14,10}));

    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0){
            return false;
        }
        LinkedList<Integer> list = new LinkedList();
        for(int i:sequence){
            list.add(i);
        }
        return dfs(list);
    }
    public boolean dfs(List<Integer> list){
        if(list.size()==1||list.size()==2||list.size()==0)return true;
        int xx=0;
        int yy=0;
        for(int x=0;x<list.size()-1;x++){
            if(list.get(x)>list.get(x+1)){
                xx++;
            }
            if(list.get(x)<list.get(x+1)){
                yy++;
            }
        }
        if(xx==0||yy==0)return true;

        int lastint=list.get(list.size()-1);
        int i=0;
        boolean flag=true;
        for(;list.get(i)<lastint;i++){}
        int j=list.size()-2;
        for(;list.get(j)>lastint&&j>0;j--){}
        if(i-1==j){
            if(!dfs(list.subList(0,i)))return false;
            if(!dfs(list.subList(i,list.size()-1)))return false;
        }else {
            return false;
        }
        return true;
    }

}
