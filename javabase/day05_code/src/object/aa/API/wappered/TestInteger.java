package object.aa.API.wappered;

import static java.lang.Integer.valueOf;

public class TestInteger {
    public static void main(String[] args) {

        //
        Integer i=Integer.valueOf("1");
        Integer i2=Integer.valueOf(2);
        int num=i.intValue();

        //基本类型转化为字符串
        String s3=""+3;
        String s=Integer.toString(1);
        String s1= String.valueOf(1);

        //字符串转化为基本类型
        int num2=Integer.parseInt(s1);


    }
}
