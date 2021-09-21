package array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 给你一个整数数组 nums 。每一次操作中，你可以将 nums 中 任意 一个元素替换成 任意 整数。
 如果 nums 满足以下条件，那么它是 连续的 ：
 nums 中所有元素都是 互不相同 的。
 nums 中 最大 元素与 最小 元素的差等于 nums.length - 1 。
 比方说，nums = [4, 2, 5, 3] 是 连续的 ，但是 nums = [1, 2, 3, 5, 6] 不是连续的 。
 请你返回使 nums 连续 的 最少 操作次数。
 *
 *
 * 题解:排序头尾算
 *
 *
 */
public class MinOperationsSolution {
    int num=0;



    @Test
    public  void test(){
        System.out.print(minOperations2(new  int[]{41,33,29,33,35,26,47,24,18,28}));
    }
    public int minOperations2(int[] nums)
    {
        int n = nums.length;
        Set<Integer> us = new HashSet<>();
        for (int x : nums)
            us.add(x);

        int an = us.size();
        int [] a = new int [an];
        int i = 0;
        for (int x : us)
            a[i ++] = x;

        Arrays.sort(a);

        int cur = 0;
        int r = 0;
        for (int l = 0; l < an; l ++)
        {
            while (r + 1 < an && a[r + 1] - a[l] <= n - 1)
                r ++;
            cur = Math.max(cur, r - l + 1);
        }
        return n - cur;
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> us = new HashSet<>();
        for (int x : nums)
            us.add(x);

        int an = us.size();
        int [] a = new int [an];
        int i = 0;
        for (int x : us)
            a[i ++] = x;
        nums=a;

        int num=0;
        Integer ynum=null;
        Arrays.sort(nums);
        for(int x=1;x<nums.length;x++){
            num=x-1;
            int sum=1;
            for(int j=x;j<nums.length;j++){
                if(sum>=nums.length){
                    num=num+nums.length-j;
                    break;
                }
                if(nums[j]>=nums[x-1]+sum&&nums[j]<=nums[x-1]+nums.length-1){
                    sum=nums[j]-nums[x-1]+1;
                }else {
                    num++;
                }
            }
            if(ynum==null||ynum>num){
                ynum=num;
            }
        }
        num=ynum==null?0:ynum.intValue();
        return num+n-an;
    }
}
