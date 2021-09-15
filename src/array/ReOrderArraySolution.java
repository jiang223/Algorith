package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 描述
 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 示例1
 *
 *
 * 题解:使用两个List最后拼接
 *
 *题解2：在原数组上操作。
 */
public class ReOrderArraySolution {
    int k=0;
    @Test
    public  void test(){
        int []result=reOrderArray(new int[]{6,5,4,3,2,6,1});
        for (int i:result){
            System.out.print(i);
        }
        //System.out.print(k);
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] reOrderArray (int[] array) {
        if (array==null){
            return  null;
        }
       List<Integer> a = new ArrayList(array.length);
       List<Integer> b = new ArrayList(array.length);
       for(int i:array){
           if(i%2==0){
               b.add(i);
           }else {
               a.add(i);
           }
       }
       a.addAll(b);
       int []result= a.stream().mapToInt(Integer::intValue).toArray();

       return  result;
    }
}
