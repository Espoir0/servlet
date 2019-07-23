package object.aa.API.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 0毫秒时刻 英国格林尼治时间1970-1-1-00:00：00
 * 中国东八区加八个小时，中国对应的0毫秒是 1970-1-1-  08:00:00
 * System.currentTimeMillis  获取现在的时刻
 */
public class Demo1 {
    public static void main(String[] args) throws ParseException {
       demo1();
       demo2();
       demo3();
    }

    /**
     * java.text.DateFormat 抽象类
     * SimpleDateFormat类继承DateFormat   日期----文本   之间的转化
     * String format(Date date);  日期格式化为字符串
     * Date parse(String str);    字符串解析为日期
     * y M d H m s S
     */
    private static void demo3() throws ParseException {
        DateFormat df=new SimpleDateFormat("yy-MM-dd-HH:mm:ss");
        String s=df.format(new Date());
        System.out.println(s);
        df.parse("19-06-28-06:50:03");//将字符串解析为Date,字符串的格式要和DF的格式相同
    }

    private static void demo2() {
        System.out.println(new Date(0L));//将毫秒数转化为对应日期
        System.out.println(new Date());//获取现在日期

    }

    private static void demo1() {
        System.out.println(System.currentTimeMillis());//获取系统当前的毫秒数
        System.out.println(new Date().getTime());      //获取1970年到现在的毫秒数

    }
}
