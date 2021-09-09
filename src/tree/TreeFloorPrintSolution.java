package tree;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
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
public class TreeFloorPrintSolution {
    @Test
    public  void test(){
        TreeNode t=new TreeNode(6);
        t.left=new TreeNode(3);
        t.left.left=new TreeNode(1);
        t.left.left.left=new TreeNode(0);
        t.left.left.right=new TreeNode(2);
        t.left.right=new TreeNode(5);
        t.right=new TreeNode(8);
        t.right.left=new TreeNode(7);
        t.right.right=new TreeNode(9);
        System.out.println(Print(t));
//        t=Deserialize(Serialize(t));
//        System.out.println(Serialize(t));
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot==null){
            return  new ArrayList();
        }
        ArrayList<ArrayList<Integer>> rowsList= new ArrayList();
        List<TreeNode> tmpList= new ArrayList();
        tmpList.add(pRoot);
        for (;tmpList.size()>0;){
            ArrayList<Integer> colList= new ArrayList();
            rowsList.add(colList);
            List<TreeNode> tmpList1=tmpList;
            tmpList=new ArrayList();
            for(TreeNode node:tmpList1){
                if(node!=null){
                    colList.add(node.val);
                }
                if(node.left!=null){
                    tmpList.add(node.left);
                }
                if(node.right!=null){
                    tmpList.add(node.right);
                }
            }
        }
        return  rowsList;
    }

}
