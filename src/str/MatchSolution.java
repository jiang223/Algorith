package str;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 描述
 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 而'*'表示它前面的字符可以出现任意次（包含0次）。
 在本题中，匹配是指字符串的所有字符匹配整个模式。
 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * 题解：
 * 利用递归的回溯
 * 每次取表达式的第一个字母与字符串比较，若满足则截取满足的部分
 *
 * 注意：*的情况有多种，需要用重复累加
 *
 * 特别注意:*的情况指代的是正则表达式前一个字母可以匹配多个
 * 日你妈
 *
 */
public class MatchSolution {
    @Test
    public  void test(){
        String a="12".substring(1);
        System.out.print(match("bcbbabab",".*a*a"));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param str string字符串
     * @param pattern string字符串
     * @return bool布尔型
     */
    public boolean match (String str, String pattern) {
        if(str.length()==0&&pattern.length()==0){
            return true;
        }else if(pattern.length()==0){
            return false;
        }
        char pchar=pattern.charAt(0);
        char xinchar='#';
        if(pattern.length()>=2){
            if(pattern.charAt(1)=='*'){
                xinchar='*';
            }

        }
        if(str.length()==0&&xinchar!='*'){
            return false;
        }
        if(xinchar=='*'){
            int i=0;
            while (true){
               if(match(str.length()==0?"":str.substring(i),pattern.substring(2)))
                   return true;
                if(str.length()>i&&(pchar==str.charAt(i)||pchar=='.')){
                    i++;
                }else {
                    break;
                }
            }
        }else if(pchar=='.'){
            if (match(str.substring(1),pattern.substring(1)))
                return true;
        }else{
            if(pchar!=str.charAt(0)){
                return false;
            }
            if(match(str.substring(1),pattern.substring(1))){
                return  true;
            }

        }
        return  false;
    }
}
