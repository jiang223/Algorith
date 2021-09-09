package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
 例如：
 给定的二叉树是{1,2,3,#,#,4,5}
 *
 * 题解 二叉树的层序反向遍历
 *
 *
 * 注意 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 */
public class TreeFloorReversePrintSolution {
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
        ArrayList t=new ArrayList<>();
        t.add(pRoot.val);
        rowsList.add(t);
        LinkedList<TreeNode> tmpList= new LinkedList<>();
        tmpList.add(pRoot);
        for (int i=1;tmpList.size()>0;i++){
            ArrayList<Integer> colList= new ArrayList();
            List<TreeNode> tmpList1=tmpList;
            tmpList=new LinkedList();
            for(TreeNode node:tmpList1){
                if(i%2==1){
                    if(node.right!=null){
                        colList.add(node.right.val);
                        tmpList.addFirst(node.right);
                    }
                    if(node.left!=null){
                        colList.add(node.left.val);
                        tmpList.addFirst(node.left);
                    }
                }else {
                    if(node.left!=null){
                        colList.add(node.left.val);
                        tmpList.addFirst(node.left);
                    }
                    if(node.right!=null){
                        colList.add(node.right.val);
                        tmpList.addFirst(node.right);
                    }
                }
            }
            if(colList.size()>0)
                rowsList.add(colList);
        }
        return  rowsList;

    }

}
