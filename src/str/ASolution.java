package str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ASolution {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            int n=in.nextInt();
            for(int i=0;i<n;i++){
                int ans=0;
                String[] ss=in.next().split("0+");
                ArrayList<String> str=new ArrayList(Arrays.asList(ss));
                ans=findLocation(str);
                if(ans>0){
                    System.out.println("Niumei");
                    System.out.println(ans);
                }else System.out.println("Draw");
            }
        }
    }
    public static int findLocation(ArrayList<String> str){
        int ans=0;
        int len=str.size();
        int[] l=new int[len];
        for(int i=0;i<len;i++){
            l[i]=str.get(i).length();
        }
        Arrays.sort(l);
        for(int i=len-1;i>=0;i--){
            if((len-1-i)%2==0) ans+=l[i];
            else ans-=l[i];
        }
        return ans;
    }
}
