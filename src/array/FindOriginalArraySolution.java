package array;

import org.junit.Test;

import java.util.*;

/**
 一个整数数组 original 可以转变成一个 双倍 数组 changed ，
 转变方式为将 original 中每个元素 值乘以 2 加入数组中，然后将所有元素 随机打乱 。
 给你一个数组 changed ，如果 change 是 双倍 数组，那么请你返回 original数组，
 否则请返回空数组。original 的元素可以以 任意 顺序返回。
 *
 *
 * 题解:hash计算
 *
 */
public class FindOriginalArraySolution {
    List<Integer> resultList = new ArrayList();
    @Test
    public  void test(){
        int [] t=findOriginalArray(new int[]{1,2,3,4,5,6,6,8,12,10});
        System.out.print(Arrays.toString(t));
    }

    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2!=0){
            return new int[]{};
        }
         Arrays.sort(changed);
         ArrayList<Integer> list = new ArrayList();
         for(int i:changed){
             list.add(i);
         }
         return dfs(list);
    }
    public int[] dfs(ArrayList<Integer> list){
        if(list.size()==0){
            return  resultList.stream().mapToInt(Integer::intValue).toArray();
        }
        int ori= list.get(0);
        for (int i=1;i<list.size();i++){
            if(list.get(i)%2==0&&list.get(i)/2==ori){
                resultList.add(ori);
                ArrayList<Integer> cloneList= (ArrayList<Integer>) list.clone();
                cloneList.remove(0);
                cloneList.remove(i-1);
                int[] result= dfs(cloneList);
                if(result.length>0)return result;
                resultList.remove(resultList.size()-1);
            }
        }
        return new int[]{};
    }
}
