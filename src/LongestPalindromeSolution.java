import org.junit.Test;

public class LongestPalindromeSolution {
    @Test
    public  void test(){
        System.out.print(getLongestPalindrome("abc1234321ab",12));
    }

    public int getLongestPalindrome(String A, int n) {
        int index=n/2;
        int indexleft,indexright;
        if(n%2==1){
             indexleft=index+1;
             indexright=index+1;
        }else{
            indexleft=index;
            indexright=index+1;
        }
        int max=0;
        int count;
        while (indexleft>0&&indexright<A.length()-1){
            if(max<=indexleft-1){
                count=getLong(A,indexleft);
                if (count>max){
                    max=count;
                }
            }
            if(max>=A.length()-indexright){
                count=getLong(A,indexright);
                if (count>max){
                    max=count;
                }
            }
            indexleft--;
            indexright++;

        }
        return  max;
    }
    public int getLong(String a,int index){
        int count=0;
        int left=index-1;
        int right=index+1;
        while(left>0&&right<a.length()-1){
            char lc=a.charAt(left--);
            char rc=a.charAt(right++);
            if(lc==rc){
                count=count+2;
            }else{
                break;
            }
        }
        if (count>2){
            count++;
        }
        return count;
    }

}
