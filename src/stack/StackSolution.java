package stack;

import org.junit.Test;

import java.util.Stack;

/**
 * 描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数，并且调用 min函数、push函数 及 pop函数 的时间复杂度都是 O(1)
 * push(value):将value压入栈中
 * pop():弹出栈顶元素
 * top():获取栈顶元素
 * min():获取栈中最小元素
 *
 *
 * 题解：
 * 用链表模拟栈的特性先进后出
 * min 通过循环比对获取
 *
 */
public class StackSolution {
    Stack<Integer> stack= new Stack();
    Stack<Integer> minstack= new Stack();

    @Test
    public  void test(){
        push(2);
        push(3);
        push(6);
        push(2);
        push(4);
        push(5);
        pop();
        pop();
        pop();



    }

    public void push(int node) {
        stack.push(node);
        if(minstack.isEmpty()){
            minstack.push(node);
        }else {
            if(node<=minstack.peek())minstack.push(node);
        }
    }

    public void pop() {
        int i=stack.pop();
        if(i==minstack.peek())minstack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minstack.peek();
    }
}
