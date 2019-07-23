package cn.aa.day04.demo1;

import java.util.Scanner;



public class Demo7Scanner {
    public static void main(String[] args) {
       max();
    }

    private static void max() {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int num2=sc.nextInt();
        int num3=sc.nextInt();
        int temp=num>num2 ? num :num2;
        int max =temp>num3 ? temp : num3;
        System.out.println(max);
    }

    public static void sum(){
        //System.in表示从键盘获取输入
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int num2=sc.nextInt();
        int num3=sc.nextInt();
        System.out.println(num+num2+num3);
    }

}
