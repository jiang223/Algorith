package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 数据范围：输入二叉树的节点数 ，二叉树中每个节点的值
 要求：空间复杂度（即在原树上操作），时间复杂度

 注意:
 1.要求不能创建任何新的结点，只能调整树中结点指针的指向。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
 2.返回链表中的第一个节点的指针
 3.函数返回的TreeNode，有左右指针，其实可以看成一个双向链表的数据结构
 4.你不用输出双向链表，程序会根据你的返回值自动打印输出
 输入描述：
 二叉树的根节点
 返回值描述：
 双向链表的其中一个头节点。
 *
 *
 *
 */
public class ConvertSolution {
    int target;
    ArrayList<ArrayList<Integer>> result= new ArrayList();
    @Test
    public  void test(){
        TreeNode t=new TreeNode(10);
        t.left=new TreeNode(6);
        t.left.left=new TreeNode(4);
//        t.left.left.left=new TreeNode(4);
//        t.left.left.right=new TreeNode(8);
        t.left.right=new TreeNode(8);
        t.right=new TreeNode(14);
        t.right.left=new TreeNode(12);
        t.right.right=new TreeNode(16);
        t=Convert(t);
        System.out.println(t.toString());
//        t=Deserialize(Serialize(t));
//        System.out.println(Serialize(t));
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null)return null;
        List<TreeNode> nodeList= new ArrayList();
        dfs(pRootOfTree,nodeList);
        for(int i=0;i<nodeList.size();i++){
            TreeNode node=nodeList.get(i);
            if(i<nodeList.size()-1) node.right=nodeList.get(i+1);
            if(i!=0) node.left=nodeList.get(i-1);
        }
        return nodeList.get(0);
    }
    public List dfs (TreeNode node, List<TreeNode> list) {
        if(node.left!=null){
            dfs(node.left,list);
        }
        list.add(node);
        if(node.right!=null){
            dfs(node.right,list);
        }
        return  list;
    }

}
