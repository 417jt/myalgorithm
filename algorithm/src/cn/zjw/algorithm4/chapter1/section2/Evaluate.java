package cn.zjw.algorithm4.chapter1.section2;

import java.security.DigestException;
import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 双栈算数表达式求值法
 */
public class Evaluate {
    public static  Pattern dig = Pattern.compile("\\d+");

        public static void main(String[] args){
        System.out.println(Arrays.toString("1+2*242/23".split("\\d+")));
        caculate("1+2*242/23");
    }
    public static void caculate(String exp){
        if (exp == null || exp.isEmpty()){
            return;
        }
        String newString = exp.replace(" ","");
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();

        Matcher matcher = dig.matcher(exp);
        while (matcher.find()){
            vals.push(Double.valueOf(matcher.group()));
            System.out.println(matcher.group());
        }
        String[] split = exp.split("\\d+");
        for(int i = 0; i < split.length; i++){
            if (split[i].isEmpty()){
                continue;
            }
            ops.push(split[i]);
            System.out.println(split[i]);
        }
      /*  Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while ()
        String[] split = exp.split("\\s");*/

    }
    public static  void getNext(String str, int index){
            int end = index + 1;
            for (int i = index + 1; i < str.length(); i++){
                //if (!str.substring(index, end).matches("\\d+"))
            }
    }
}
