package cn.aa.day04.demo2;
/**
 * 将任意字符串升序排序，然后反转并输出
 * 对数组倒序输出即可
 */

import java.util.Arrays;

public class Demo10StringSort {
    public static void main(String[] args) {
        String s="dlakfadkhvna9655DDDf";
        reverse(s);
        reverse2(s);
    }

    private static void reverse(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String s1 = Arrays.toString(chars);
        System.out.println(s1);
        s1=new StringBuilder(s1).reverse().toString();
        System.out.println(s1);
    }

    private static void reverse2(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        char temp;
        for (int i = 0; i < chars.length/2; i++) {

            temp=chars[i];
            chars[i]=chars[chars.length-1-i];
            chars[chars.length-1-i]=temp;

        }
        s = Arrays.toString(chars);
        System.out.println(s);
    }


}
