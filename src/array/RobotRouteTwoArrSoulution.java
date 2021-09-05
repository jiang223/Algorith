package array;

import org.junit.Test;

/**
 描述
 地上有一个rows行和cols列的方格。坐标从 [0,0] 到 [rows-1,cols-1]。
 一个机器人从坐标0,0的格子开始移动，
 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于threshold的格子。
 例如，当threshold为18时，机器人能够进入方格[35,37]，因为3+5+3+7 = 18。但是，它不能进入方格[35,38]，因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 范围:
 1 <= rows, cols<= 100
 0 <= threshold <= 20
 *
 * 输入：
 * threshold 1, rows2,cols3
 * 复制
 * 返回值：3
 *
 *
 * 题解 1
 * 运用递归的回溯算法。找到开始下一节点，如果四个节点相加都大于threshold则返回上一节点。
 * 从00开始走，遇到小于threshold则++1，最后返回路径节点总数和
 *
 * 题解 2
 * 运用遍历算法，从x+1开始，到大于threshold时则将x=0,从y+1。从新开始，直至y+1都大于threshold
 *
 *
 * 注意：
 * 边界值的判断，已走过的节点不能再++1
 *
 *
 [[a,b,c,e],[s,f,c,s],[a,d,e,e]]
 */
public class RobotRouteTwoArrSoulution {
    int sum=0;
    @Test
    public  void test(){
//        char[][] matrix= new char[][]{
//            {'a','b','c','e'},
//            {'s','f','c','s'},
//            {'a','d','e','e'}
//        };
//        String word="abccedfh";
//        char[][] matrix= new char[][]{
//                {'a','b','c','e'},
//                {'s','f','c','s'},
//                {'a','d','e','e'}
//        };
//        String word="see";
//        boolean result=hasPath(matrix,word);
//        System.out.print(result);
//
//        boolean result=sumindexXY(12,31,5);
//        System.out.print(result);
        System.out.println(sumindexXY(0,2,1));
        System.out.println(movingCount(10,1,100));
      // [[A,B,C,E],[S,F,C,S],[A,D,E,E]],"ABCB"
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param threshold char字符型二维数组
     * @param rows string字符串
     * @return cols
     */
    public int movingCount(int threshold, int rows, int cols) {
           return dfs(new char[rows][cols],0,0,threshold);
    }
    public  int dfs(char[][] nowMatrix,int nowy,int nowx,int threshold){
        char tmp = nowMatrix[nowy][nowx];
        if('.'!=nowMatrix[nowy][nowx]&&sumindexXY(nowy,nowx,threshold)){
            nowMatrix[nowy][nowx] = '.';
            sum++;
            //front
            if(nowy>0){
                dfs(nowMatrix,nowy-1,nowx,threshold);
            }
            //right
            if(nowx<nowMatrix[nowy].length-1){
                dfs(nowMatrix,nowy,nowx+1,threshold);
            }
            //nowMatrix[nowy][++nowx];
            //back
            if(nowy<nowMatrix.length-1){
                dfs(nowMatrix,nowy+1,nowx,threshold);
            }
            //nowMatrix[++nowy][nowx];
            //left
            if(nowx>0){
                dfs(nowMatrix,nowy,nowx-1,threshold);
            }
        }
        return  sum;
        //nowMatrix[nowy][--nowx];
    }
    public  boolean sumindexXY(int y,int x,int threshold){
        String ystr=y+"";
        String xstr=x+"";
        int sum = 0;
        for(char yc:ystr.toCharArray()){
            sum=sum+new  Integer(yc+"");
        }
        for(char yx:xstr.toCharArray()){
            sum=sum+new  Integer(yx+"");
        }
        if(sum>threshold){
            return false;
        }else {
            return  true;
        }
    }



}
