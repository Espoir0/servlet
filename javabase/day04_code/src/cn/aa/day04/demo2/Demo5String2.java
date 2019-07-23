package cn.aa.day04.demo2;



public class Demo5String2 {
    public static void main(String[] args) {
        //存在常量池当中
        String str1="abc";
        String str2="abc";


        char[] charArray={'a','b','c'};
        //new 出来的对象都在堆中但不在常量池当中
        String str3=new String(charArray);
        System.out.println(str1==str2);
        System.out.println(str1==str3);
        System.out.println(str2==str3);

        System.out.println("how are you ".replace("o","*"));
        String s="aa,bb,cc";
        String[] str = s.split(",");
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}