package str;

import java.util.*;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 后台会用以下方式调用Insert 和 FirstAppearingOnce 函数
 *
 * 题解：
 * 利用队列先
 *
 */
public class FirstAppearingOnceSolution {
    private Deque<Character> deque = new ArrayDeque<>();
    private int[] count = new int[128];
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (count[ch] == 0) {
            deque.offer(ch);
        }
        count[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        while (!deque.isEmpty() && count[deque.peek()] > 1) {
            deque.poll();
        }
        return deque.peek() == null ? '#' : deque.peek();
    }
}
