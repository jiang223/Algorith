package array;

import org.junit.Test;

import java.util.Arrays;

/**
 * 描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任一一个重复的数字。 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。存在不合法的输入的话输出-1
 * 示例1
 * 输入：
 * [2,3,1,0,2,5,3]
 * 复制
 * 返回值：
 * 2
 * 复制
 * 说明：
 * 2或3都是对的
 *
 *
 * 题解:hash计算
 *
 *题解2：根据长度2的特性进行数组数据脚标判断
 */
public class DuplicateSolution {
    int k=0;
    @Test
    public  void test(){
        System.out.print(duplicate(new int[]{6,5,4,3,2,6,1}));
        System.out.print(k);
    }


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numbers int整型一维数组
     * @return int整型
     */
    public int duplicate (int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            k++;
            if (numbers[i] != i){
                if (numbers[i] == numbers[numbers[i]]) return numbers[i];
                int temp = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = temp;
                i--;//遍历完0位元素以及交换完数字后，如果0位元素仍不符合数组存放原则：numbers[i] = i，那么还要重新遍历0位元素
            }
        }

        return -1;

    }
}
