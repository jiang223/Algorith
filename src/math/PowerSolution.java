package math;

import org.junit.Test;

/**
 描述
 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。

 保证base和exponent不同时为0。不得使用库函数，同时不需要考虑大数问题，也不用考虑小数点后面0的位数。

 题解：
    暴力解法
 *
 *
 */
public class PowerSolution {
    public double Power(double base, int exponent) {
        if(exponent==0){
            return  1;
        }
        double num=base;
        for (;exponent>1;){
            num=base*num;
            exponent--;
        }
        for (;exponent<-1;){
            num=base*num;
            exponent++;
        }
        if(exponent==-1){
            return  1/num;
        }
        return num;
    }
    @Test
    public  void test(){
        System.out.print(Power(2.00000,-3));
    }

}
