package array;

import org.junit.Test;

/**
 *描述
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 \begin{bmatrix} a & b & c &e \\ s & f & c & s \\ a & d & e& e\\ \end{bmatrix}\quad​
 * 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * 输入：
 * [[a,b,c,e],[s,f,c,s],[a,d,e,e]],"abcced"
 * 返回值：
 * true
 *
 *
 * 题解
 * 运用递归的回溯算法。找到开始下一节点，如果四个方向都没找到退回上个节点。
 * 直至for循环完所有节点为止
 *
 * 注意：
 * 边界值的判断,当前节点不能移动回上一节点
 *
 *
 [[a,b,c,e],[s,f,c,s],[a,d,e,e]]
 */
public class RouteTwoArrSoulution {
    @Test
    public  void test(){
//        char[][] matrix= new char[][]{
//            {'a','b','c','e'},
//            {'s','f','c','s'},
//            {'a','d','e','e'}
//        };
//        String word="abccedfh";
        char[][] matrix= new char[][]{
                {'a','b','c','e'},
                {'s','f','c','s'},
                {'a','d','e','e'}
        };
        String word="see";
        boolean result=hasPath(matrix,word);
        System.out.print(result);
      // [[A,B,C,E],[S,F,C,S],[A,D,E,E]],"ABCB"
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param matrix char字符型二维数组
     * @param word string字符串
     * @return bool布尔型
     */
    public boolean hasPath (char[][] matrix, String word) {
       for(int i=0;i<matrix.length;i++){
           for(int j=0;j<matrix[i].length;j++){
               if(word.charAt(0)==matrix[i][j]){
                   if (dfs(word.substring(1),matrix,i,j))return  true;
               }
               //matrix[i][j];
           }
       }
        return  false;

    }
    public  boolean dfs(String nowWord,char[][] nowMatrix,int nowy,int nowx){
        char tmp = nowMatrix[nowy][nowx];
        nowMatrix[nowy][nowx] = '.';
        if (nowWord.length()==0){
            return true;
        }
        //front
        if(nowy>0&&nowWord.charAt(0)==nowMatrix[nowy-1][nowx]){
              if(dfs(nowWord.substring(1),nowMatrix,nowy-1,nowx))return true;
        }
        //right
        if(nowx<nowMatrix[nowy].length-1&&nowWord.charAt(0)==nowMatrix[nowy][nowx+1]){
              if(dfs(nowWord.substring(1),nowMatrix,nowy,nowx+1))return true;
        }
        //nowMatrix[nowy][++nowx];
        //back
        if(nowy<nowMatrix.length-1&&nowWord.charAt(0)==nowMatrix[nowy+1][nowx]){
              if(dfs(nowWord.substring(1),nowMatrix,nowy+1,nowx))return  true;
        }
        //nowMatrix[++nowy][nowx];
        //left
        if(nowx>0&&nowWord.charAt(0)==nowMatrix[nowy][nowx-1]){
              if(dfs(nowWord.substring(1),nowMatrix,nowy,nowx-1))return  true;
        }
        nowMatrix[nowy][nowx] =tmp;
        return  false;
        //nowMatrix[nowy][--nowx];
    }



}
