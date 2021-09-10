package tree;
/**
 * /**
 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的next指针。
 下图为一棵有9个节点的二叉树。
 树中从父节点指向子节点的指针用实线表示，从子节点指向父节点的用虚线表示

 题解：
 动态规划，分析节点不同位置时的规律。

 d:节点，没有左右子树，是父树的左节点，中序下一点为父节点
 b:节点，有左右子树，是父树的左节点，中序下一点为右节点的中序第一个
 e\a:节点，有左右子树，是父树的右节点或没有父节点，中序下一点为左节点的中序第一个
 d:节点，没有左右子树，是父树的右节点，中序下一点为父节点是左子树的情况，若无则没有下一中序节点

 *  */
import org.junit.Test;
public class GetNextSoulution {//TODO
    @Test
    public  void test(){
        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        t.left.left=new TreeNode(3);
        t.right=new TreeNode(4);
        boolean a= isSymmetric(t);
    }

    boolean t=true;
    /**
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isSymmetric (TreeNode root) {
        lisSymmetric(root.left,root.right);
        return  t;
        // write code here
    }
    public void lisSymmetric (TreeNode left,TreeNode right) {
        if(left==null||right==null){
            if(left!=null){
                t=  false;
                return;
            }
            if(right!=null){
                t=  false;
                return;
            }
            return;

        }
        if(left.val!=right.val){
            t=  false;
            return;
        }
        lisSymmetric(left.left,right.right);
        lisSymmetric(left.right,right.left);

    }

}
