package math;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * 描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 输入：
 * [5,2,3,4,1,6,7,0,8]
 * 返回值：
 * "5.00 3.50 3.00 3.50 3.00 3.50 4.00 3.50 4.00 "
 * 说明：
 *
 *
 * 题解
 *1、大小顶堆存储中位数。总数为奇数返回大顶堆头，总数为偶返回大小顶堆的平均值
 *2、通过二分法插入排序获的排序好的数组结构
 *
 *
 */
public class MedianSolution {
    PriorityQueue<Integer> bigqueue= new PriorityQueue<Integer>((a,b) -> (b-a));
    PriorityQueue<Integer> smallqueue= new PriorityQueue();
    public void Insert(Integer num) {
        bigqueue.add(num);
        if(bigqueue.size()-smallqueue.size()==2){
            smallqueue.add(bigqueue.poll());
        }
        if(smallqueue.size()>0&&bigqueue.peek()>smallqueue.peek()){
            smallqueue.add(bigqueue.poll());
        }
    }

    public Double GetMedian() {
        if(bigqueue.size()+smallqueue.size()==1)
            return bigqueue.peek()/1.0;
        if(bigqueue.size()>smallqueue.size()){
            return bigqueue.peek()/1.0;
        }else if(bigqueue.size()<smallqueue.size()){
            return smallqueue.peek()/1.0;
        }else {
            return  (smallqueue.peek()+bigqueue.peek())/2.0;
        }

    }
    @Test
    public  void test(){
        Insert(5);
        Insert(2);
        Insert(3);
        Insert(4);
        Insert(1);
//        Insert(6);
//        Insert(7);
//        Insert(0);
//        Insert(8);
        System.out.println(GetMedian());
    }

}
