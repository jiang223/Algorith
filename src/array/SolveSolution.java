package array;

import org.junit.Test;

public class SolveSolution {
    @Test
    public  void test(){
        System.out.print(solve(new int[]{0,1,2,3,4,5,7}));
    }


    public int solve (int[] a) {
       int reint;
       for(int i=0;i<a.length-1;i++){
           if(a[i]+1!=a[i+1]){
               return  a[i]+1;
           }
       }
       if(a[0]!=0){
           return  0;
       }else {
           return  a[a.length-1]+1;
       }

    }
}
