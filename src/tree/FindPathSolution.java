package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 描述
 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 例如：
 给定的二叉树是{1,2,3,#,#,4,5}
 *
 * 题解 二叉树的层序遍历
 *
 *
 * 注意 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 */
public class FindPathSolution {
    int target;
    ArrayList<ArrayList<Integer>> result= new ArrayList();
    @Test
    public  void test(){
        TreeNode t=new TreeNode(10);
        t.left=new TreeNode(5);
        t.left.left=new TreeNode(4);
//        t.left.left.left=new TreeNode(0);
//        t.left.left.right=new TreeNode(2);
        t.left.right=new TreeNode(7);
        t.right=new TreeNode(12);
//        t.right.left=new TreeNode(7);
//        t.right.right=new TreeNode(9);
        System.out.println(FindPath(t,22).toString());
//        t=Deserialize(Serialize(t));
//        System.out.println(Serialize(t));
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null){
            return result;
        }
        this.target=target;
        Print(root,0,new ArrayList());
        return  result;
    }
    void Print(TreeNode pRoot,int sum,ArrayList<Integer> list) {
        sum=sum+pRoot.val;
        list.add(pRoot.val);
        if(pRoot.left!=null){
            Print(pRoot.left,sum,list);
            list.remove(list.size()-1);
        }
        if(pRoot.right!=null){
            Print(pRoot.right,sum,list);
            list.remove(list.size()-1);
        }
        if(pRoot.left==null&&pRoot.right==null&&sum==target){
            result.add((ArrayList<Integer>) list.clone());
        }
    }
}
