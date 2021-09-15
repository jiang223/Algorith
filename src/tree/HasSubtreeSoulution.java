package tree;
/**
 * /**
 描述
 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）

 题解：
 层序遍历，先从头节点开始判断，满足条件

 d:节点，没有左右子树，是父树的左节点，中序下一点为父节点
 b:节点，有左右子树，是父树的左节点，中序下一点为右节点的中序第一个
 e\a:节点，有左右子树，是父树的右节点或没有父节点，中序下一点为左节点的中序第一个
 d:节点，没有左右子树，是父树的右节点，中序下一点为父节点是左子树的情况，若无则没有下一中序节点

 *  */
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class HasSubtreeSoulution {//TODO
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


        TreeNode t2=new TreeNode(3);
        //t2.left=new TreeNode(2);
        t2.right=new TreeNode(4);
        boolean a= HasSubtree(t,t2);
        System.out.print(a);
    }

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1==null&&root2!=null){
            return false;
        }
        if(root1!=null&&root2==null){
            return false;
        }
        if(root1==null&&root2==null){
            return false;
        }
        List<TreeNode> tmpList= new ArrayList();
        tmpList.add(root1);
        for (;tmpList.size()>0;){
            List<TreeNode> tmpList1=tmpList;
            tmpList=new ArrayList();
            for(TreeNode node:tmpList1){
                if(node.val==root2.val){
                    if(dfs(root2,node))return  true;
                }
                if(node.left!=null){
                    tmpList.add(node.left);
                }
                if(node.right!=null){
                    tmpList.add(node.right);
                }
            }
        }
        return  false;

    }
    public boolean dfs (TreeNode node1, TreeNode node2) {
        if(node1==null&&node2==null)return  true;
        if(node1==null||node2==null)return  false;
        if(node1.val!=node2.val){
            return false;
        }
        if(node1.left!=null){
             if(!dfs(node1.left,node2.left))return  false;
        }
        if(node1.right!=null){
            if(!dfs(node1.right,node2.right))return  false;
        }
        return  true;
    }

}
