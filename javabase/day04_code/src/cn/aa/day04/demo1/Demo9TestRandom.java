package cn.aa.day04.demo1;

import java.util.Random;

public class Demo9TestRandom {
    public static void main(String[] args) {
        Random r = new Random();
        int num=r.nextInt();        //获取任意的随机整数
        int num2=r.nextInt(10);  //获取[0,10)之间的整数，左闭右开；
        int num3=r.nextInt(10)+1;  //获取[1,10]之间的整数
        System.out.println(num3);
    }
}
