package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class PrmuteUniqueSolution {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    @Test
    public  void test(){

        permuteUnique(new int[]{1,1,3});
        System.out.print(result.toString());

    }

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);//从小到大排序
        boolean []bnum = new boolean[num.length];
        for (boolean b:bnum)
            b=false;
        devs(num,0,new ArrayList<Integer>(),bnum);

        return result;
    }
    public void  devs(int []num, int index, ArrayList<Integer> re,boolean []bnum){
        if(re.size()==num.length){
            result.add((ArrayList)re.clone());
        }
        for(int i=0;i<num.length;i++){
            if(i>=1&&num[i]==num[i-1]){
                continue;
            }
            if(!bnum[i]){
                re.add(num[i]);
                bnum[i]=true;
                devs(num,index,re,bnum);
                re.remove(re.size()-1);
                bnum[i]=false;
            }
        }
    }


}
