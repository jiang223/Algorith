package tree;

import org.junit.Test;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}

public class SymmetricSolution {
    @Test
    public  void test(){
        TreeNode t=new TreeNode();
        t.left=new TreeNode();
        t.left.left=new TreeNode();
        t.right=new TreeNode();
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
