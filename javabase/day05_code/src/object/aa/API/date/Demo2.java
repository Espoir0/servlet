package object.aa.API.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 计算一个人到现在出生多少天：
 *
 */
public class Demo2 {
    public static void main(String[] args) throws ParseException {
        System.out.println("请输入的你出生日期：格式：例如2020年1月一日  ： 20000101");
        Scanner sc =new Scanner(System.in);
        String s=sc.next();
        calculateDay(s);
    }

    private static void calculateDay(String s) throws ParseException {
        DateFormat df=new SimpleDateFormat("yyyyMMdd");
        Date d=df.parse(s);

        Date nowDate=new Date();
        Long day=(nowDate.getTime()-d.getTime())/1000/3600/24;
        System.out.println("你已经出生了 "+day+ " 天");
        System.out.println("你已经 "+(day/365)+"岁了");
    }
}
