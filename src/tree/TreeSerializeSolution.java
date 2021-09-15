package tree;

import org.junit.Test;

import java.util.ArrayDeque;


/**
 请实现两个函数，分别用来序列化和反序列化二叉树，不对序列化之后的字符串进行约束，但要求能够根据序列化之后的字符串重新构造出一棵与原二叉树相同的树。

 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树等遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。

 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。

 例如，可以根据层序遍历并特定标志空结点的方案序列化，也可以根据满二叉树结点位置的标号规律来序列化，还可以根据先序遍历和中序遍历的结果来序列化。

 假如一棵树共有 2 个结点， 其根结点为 1 ，根结点右子结点为 2 ，没有其他结点。按照上面第一种说法可以序列化为“1,#,2,#,#”，按照上面第二种说法可以序列化为“{0:1,2:2}”，按照上面第三种说法可以序列化为“1,2;2,1”，这三种序列化的结果都包含足以构建一棵与原二叉树完全相同的二叉树的信息。

 不对序列化之后的字符串进行约束，所以欢迎各种奇思妙想。
 *
 * 题解 简单的方法二叉树的前序遍历序列化，后用相同方式反序列化
 *
 *
 * 注意 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 */
public class TreeSerializeSolution {
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
        System.out.println(Serialize(t));
        t=Deserialize("8,1,2,9,1,2,3,5");
        System.out.println(Serialize(t));
    }

    /**
     * 前序遍历打印返回str
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        if(root==null){
            return null;
        }
        return  dfsfront(root,new StringBuffer());
    }
    String dfsfront(TreeNode root,StringBuffer str){
        if(str.length()==0){
            str.append(root.val+"");
        }else {
            str.append(","+root.val+"");
        }
        if(root.left!=null){
            dfsfront(root.left,str);
        }else{
            str.append(",#");
        }
        if (root.right!=null){
            dfsfront(root.right,str);
        }else{
            str.append(",#");
        }
        return str.toString();
    }

    TreeNode Deserialize(String str) {//用队列全弹飞
        if(str==null){
            return null;
        }
        String[] strs=str.split(",");
        ArrayDeque<String> ArrayDequestr= new ArrayDeque();
        for(String s:strs){
            ArrayDequestr.add(s);
        }
       return  dfsfrontDe(new TreeNode(),ArrayDequestr);
    }
    TreeNode dfsfrontDe(TreeNode root,ArrayDeque<String> ArrayDequestr){
        root.val=new Integer(ArrayDequestr.poll());
        if(!ArrayDequestr.peek().equals("#")){
            root.left=new TreeNode();
            dfsfrontDe(root.left,ArrayDequestr);
        }else{
            ArrayDequestr.poll();
            root.left=null;
        }
        if (!ArrayDequestr.peek().equals("#")){
            root.right=new TreeNode();
            dfsfrontDe(root.right,ArrayDequestr);
        }else{
            ArrayDequestr.poll();
            root.right=null;
        }
        return  root;
    }

}
