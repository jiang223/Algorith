package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 描述
 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 * 题解 二叉树的层序遍历
 *
 * 注意 传入空的判断
 */
public class MirrorSolution {
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
        t= Mirror(t);
        ArrayList<ArrayList<Integer>> ta =new TreeFloorPrintSolution().Print(t);
        System.out.print(ta);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public TreeNode Mirror (TreeNode pRoot) {
        if(pRoot==null)return  null;
        TreeNode tmpNode=pRoot.left;
        pRoot.left=pRoot.right;
        pRoot.right= tmpNode;
        if(pRoot.left!=null){
            Mirror(pRoot.left);
        }
        if(pRoot.right!=null){
            Mirror(pRoot.right);
        }
        return  pRoot;
        // write code here
    }

    public TreeNode Mirror2 (TreeNode pRoot) {
        if(pRoot==null)return  null;
        List<TreeNode> tmpList= new ArrayList();
        tmpList.add(pRoot);
        for (;tmpList.size()>0;){
            List<TreeNode> tmpList1=tmpList;
            tmpList=new ArrayList();
            for(TreeNode node:tmpList1){
                TreeNode tmpNode=node.left;
                node.left=node.right;
                node.right= tmpNode;
                if(node.left!=null){
                    tmpList.add(node.left);
                }
                if(node.right!=null){
                    tmpList.add(node.right);
                }
            }

        }
        return  pRoot;

        // write code here
    }

}
