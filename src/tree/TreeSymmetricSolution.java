package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 描述
 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * 题解 二叉树的层序遍历判断
 *  *
 *
 *
 */
public class TreeSymmetricSolution {
    @Test
    public  void test(){
        TreeNode t=new TreeNode(8);
        t.left=new TreeNode(6);
        t.left.left=new TreeNode(5);
//        t.left.left.left=new TreeNode(0);
//        t.left.left.right=new TreeNode(2);
        t.left.right=new TreeNode(7);
        t.right=new TreeNode(6);
        t.right.left=new TreeNode(7);
        t.right.right=new TreeNode(5);
        System.out.println(isSymmetrical(t));
//        t=Deserialize(Serialize(t));
//        System.out.println(Serialize(t));
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot==null){
            return true;
        }else if(pRoot.right==null&&pRoot.left==null){
            return true;
        }
        ArrayList<TreeNode> lNodes= new ArrayList();
        lNodes.add(pRoot.left);
        ArrayList<TreeNode> rNodes= new ArrayList();
        rNodes.add(pRoot.right);
        if(pRoot.left==null||pRoot.right==null||pRoot.left.val!=pRoot.right.val){
            return  false;
        }
        for (;lNodes.size()!=0&&rNodes.size()!=0;){
            StringBuffer lstr=new StringBuffer();
            StringBuffer rstr=new StringBuffer();
            lNodes=Print(lNodes,lstr);
            rNodes=reversePrint(rNodes,rstr);
            if(!lstr.toString().equals(rstr.toString())){
                return  false;
            }
        }
        return  true;
    }

    /**
     * 需要返回str和下一层的list
     * @param listNodes
     * @return
     */
    ArrayList<TreeNode> Print(ArrayList<TreeNode> listNodes,StringBuffer str) {
        ArrayList<TreeNode> tmpList= listNodes;
        listNodes= new ArrayList();

        for(TreeNode node:tmpList){
            if(node.left!=null){
                str.append(node.left.val+",");
                listNodes.add(node.left);
            }else {
                str.append("#,");
            }
            if(node.right!=null){
                str.append(node.right.val+",");
                listNodes.add(node.right);
            }else {
                str.append("#,");
            }
        }
        return  listNodes;
    }
    ArrayList<TreeNode> reversePrint(ArrayList<TreeNode> listNodes,StringBuffer str) {
        ArrayList<TreeNode> tmpList= listNodes;
        listNodes= new ArrayList();
        for(TreeNode node:tmpList){
            if(node.right!=null){
                str.append(node.right.val+",");
                listNodes.add(node.right);
            }else {
                str.append("#,");
            }
            if(node.left!=null){
                str.append(node.left.val+",");
                listNodes.add(node.left);
            }else {
                str.append("#,");
            }
        }
        return  listNodes;
    }

}
