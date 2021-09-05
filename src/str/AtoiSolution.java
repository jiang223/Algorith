package str;

import org.junit.Test;

public class AtoiSolution {
    @Test
    public  void test(){
        atoi("-13");
    }
    /**
     *
     * @param str string字符串
     * @return int整型
     */
    public int atoi (String str) {
        str=str.trim();
        if(str.equals(""))
            return 0;
        return  Integer.valueOf(str);
    }
}
