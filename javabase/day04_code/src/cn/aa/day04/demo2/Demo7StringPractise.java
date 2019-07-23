package cn.aa.day04.demo2;

import java.util.Scanner;

/**
 * 从键盘输入一个字符串，统计字符串中、
 * 四种类型，大写字母，小写字母，数字，和其他字符种类出现的字符出现的次数
 *
 */
public class Demo7StringPractise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        //初始化四种类型的出现次数
        int countUpper = 0;
        int countLower = 0;
        int countNumber = 0;
        int countOther = 0;

        //将字符串变为字符数组
        char[] chars=str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if(chars[i]>='A' && chars[i]<='Z'){
                countUpper++;
            }else if(chars[i]>='a' && chars[i]<='z'){
                countLower++;
            }else if(chars[i]>'0' && chars[i]<='9'){
                countNumber++;
            }else {
                countOther++;
            }
        }
    }
}
