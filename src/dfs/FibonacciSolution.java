package dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FibonacciSolution {
    @Test
    public  void test(){
        System.out.print(Fibonacci(4));
    }

    public int Fibonacci(int n) {
        List<Integer> list = new ArrayList();
        if(n==0){
            return  0;
        }
        if (n==1){
            return  1;
        }
        list.add(0);
        list.add(1);
        for(int i=0;i<n-1;i++){
            list.add(list.get(i)+list.get(i+1));
        }
        return list.get(list.size()-1);
    }
}
