package object.aa.API.calendar;

import java.util.Calendar;
import java.util.Date;

public class TestCalender {
    public static void main(String[] args) {
        demo1();

    }

    private static void demo1() {
        //Calender类中有很多静态字段
        Calendar c=Calendar.getInstance();//获得一个日历对象
        System.out.println(c);

        //set();方法.设置日历对象某个字段的具体值
        c.set(Calendar.MONTH,1);

        //add();方法   设置某个字段的值增加
        c.add(Calendar.MONTH,9);

        int month=c.get(Calendar.MONTH);//get()获取日历字段对应的具体值
        int day=c.get(Calendar.DAY_OF_MONTH);//get()获月中的第几天
        System.out.println(month);
        System.out.println(day);

        //getTime();吧日历转化为日期
        Date d=c.getTime();
        System.out.println(d);
    }
}
