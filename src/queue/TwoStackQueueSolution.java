package queue;

import org.junit.Test;

import java.util.Stack;

public class TwoStackQueueSolution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    @Test
    public  void test(){
        push(1);
        push(2);
        push(3);
        System.out.print(pop());
        push(4);
        System.out.print(pop());
        System.out.print(pop());
        System.out.print(pop());
    }

    public void push(int node) {
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
