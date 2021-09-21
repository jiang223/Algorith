package array;

import org.junit.Test;

/**
 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 |x| 的值定义为：
 如果 x >= 0 ，那么值为 x 。
 如果 x < 0 ，那么值为 -x 。
 *
 *
 * 题解:hash计算
 *
 *题解2：根据长度2的特性进行数组数据脚标判断
 */
public class CountKDifferenceSolution {
    int num=0;



    @Test
    public  void test(){
        System.out.print(countKDifference(new  int[]{3,2,1,5,4},2));
    }

    public int countKDifference(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(k==Math.abs(nums[i]-nums[j]))num++;
            }

        }
        return  num;
    }
}
