package dfs;

import org.junit.Test;

import java.util.ArrayList;

public class GenerateParenthesisSolution {
    ArrayList <String> a= new ArrayList<String>();

    @Test
    public  void test(){
        generateParenthesis(3);
        System.out.print(a.toString());
    }

    /**
     *
     * @param n int整型
     * @return string字符串ArrayList
     */
    public ArrayList<String> generateParenthesis (int n) {
        dsv(n,n,"");
        return  a;
    }
    public void dsv(int x,int y,String var){
        if(x+y==0){
            a.add(var);
            return;
        }
        if(x>0){
            dsv(x-1,y,var+"(");
        }
        if(x<y&&y>0){
            dsv(x,y-1,var+")");
        }
    }
}
