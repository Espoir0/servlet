package cn.aa.day04.demo1;

import java.util.Scanner;

/**
 * 匿名对象的使用
 */
public class Demo8Aonoymous {
    public static void main(String[] args) {
        //普通方式
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();

        //匿名对象方式
        int num2=new Scanner(System.in).nextInt();

        //一般情况传参
        Scanner sc2=new Scanner(System.in);
        test(sc2);

        //匿名对象作为参数
        test(new Scanner(System.in));

    }
    public static void test(Scanner in){

    }

    //匿名对象作为返回值
    public static Scanner test2(){
        return new Scanner(System.in);
    }

}
