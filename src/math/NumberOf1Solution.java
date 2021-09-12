package math;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 描述
 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 示例1

 题解：
 直接用java的进制方法
 *
 *
 */
public class NumberOf1Solution {
    public int NumberOf1(int n) {
        String binary=Integer.toBinaryString(n);
        int i=0;
        for(char c:binary.toCharArray()){
            if(c=='1')i++;

        }
        return i;
    }
    @Test
    public  void test(){
        System.out.print(NumberOf1(10));
    }

}
