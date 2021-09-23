package array;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 描述
 给一个长度为n的数组，数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。

 数据范围：，数组中元素的值
 要求：空间复杂度：，时间复杂度
 输入描述：
 保证数组输入非空，且保证有解
 *
 *
 * 题解:hash计算
 *
 */
public class MoreThanHalfNum_SolutionSolution {
    int num=0;



    @Test
    public  void test(){
        System.out.print(MoreThanHalfNum_Solution(new  int[]{3,1,1,1,4}));
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length==1){
            return array[0];
        }
        Map<Integer,Integer> map = new HashMap();
        for(int i:array){
            Integer index=map.get(i);
            if(index==null){
                map.put(i,1);
            }else {
                index=index+1;
                if(index>array.length/2){
                    return i;
                }else {
                    map.put(i,index);
                }
            }
        }
        return 0;
    }
}
