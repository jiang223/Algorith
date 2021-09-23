package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 描述
 给定一个长度为n的可能有重复值的数组，找出其中不去重的最小的k个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
 数据范围：
 要求：空间复杂度  ，时间复杂度
 *
 *
 * 题解:hash计算
 *
 */
public class GetLeastNumbersSolution {
    int num=0;



    @Test
    public  void test(){
        System.out.print(GetLeastNumbers_Solution(new  int[]{3,1,1,1,4},2));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(k==0){
            return  new ArrayList<>();
        }
        PriorityQueue<Integer> bigqueue = new PriorityQueue<Integer>((a,b) -> (b-a));
        for(int i:input){
            if(bigqueue.size()==k){
                if(bigqueue.peek()>i){
                    bigqueue.poll();
                    bigqueue.add(i);
                }
            }else {
                bigqueue.add(i);
            }
        }
        return  new ArrayList<>(bigqueue);

    }
}
