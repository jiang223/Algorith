package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 描述
 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * 题解 二叉树的层序反向遍历
 *
 *
 * 注意 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 */
public class PrintFromTopToBottomSolution {
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
        System.out.println(PrintFromTopToBottom(t));
//        t=Deserialize(Serialize(t));
//        System.out.println(Serialize(t));
    }

    ArrayList<Integer> PrintFromTopToBottom(TreeNode pRoot) {
        if(pRoot==null){
            return  new ArrayList();
        }
        ArrayList<Integer> rowsList= new ArrayList();
        rowsList.add(pRoot.val);
        LinkedList<TreeNode> tmpList= new LinkedList<>();
        tmpList.add(pRoot);
        for (int i=1;tmpList.size()>0;i++){
            List<TreeNode> tmpList1=tmpList;
            tmpList=new LinkedList();
            for(TreeNode node:tmpList1){
                if(node.left!=null){
                    rowsList.add(node.left.val);
                    tmpList.add(node.left);
                }
                if(node.right!=null){
                    rowsList.add(node.right.val);
                    tmpList.add(node.right);
                }
            }
        }
        return  rowsList;

    }

}
