package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * 描述
 * 给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
 *
 * 题解 二叉树的中序遍历
 */
public class TreeMidEachSolution {
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
        System.out.println(KthNode(t,3).val);
    }

    boolean t=true;
    /**
     *
     * @param pRoot TreeNode类
     * @return bool布尔型
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if(k==0){
            return null;
        }
        if(pRoot==null){
            return  null;
        }
        List<TreeNode> list = new ArrayList();
        dfs(pRoot,list);
        if(k>list.size()){
            return null;
        }
        return list.get(k-1);
    }
    public List dfs (TreeNode node,List<TreeNode> list) {
        if(node.left!=null){
            dfs(node.left,list);
        }
        System.out.print(node.val);
        list.add(node);
        if(node.right!=null){
            dfs(node.right,list);
        }
        return  list;
    }

}
