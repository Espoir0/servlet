package object.aa.API.stringbuilder;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        demo1();
        demo2();
    }

    private static void demo2() {
        //String 和StringBuilder之间的转化
        String str="aaa";
        StringBuilder builder = new StringBuilder(str);
        builder.append("hello");
        String s = builder.toString();
        System.out.println(s);
    }

    private static void demo1() {
        StringBuilder builder = new StringBuilder();//默认为16个字符容量
        StringBuilder builder2 = new StringBuilder("asdf");//字符串长度+16  容量
        System.out.println(builder2);

        builder.append(4).append(new Date()).append("aa");
        System.out.println(builder);


    }
}
