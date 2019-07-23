package cn.aa.day04.demo2;

/**
 * java中所有字符串字面值（"aa"）都是String类实现
 * 就是所有双引号的字符串，都是String类对象，（没有new也照样是）
 *
 * 2.字符串特点：不可变 ，只要内容相同就是同一个，所以共享使用
 * 3.字符串效果上相当于char[]型数组，但是底层原理是byte[]字节数组
 */

public class Demo4String {
    /**
     * 字符串创建方式：
     * String a="aa";
     * String("aa");
     * String(byte[] arr);
     * String(char[] arr);
     */
    public static void main(String[] args) {
        String a="aa";
        String b=new String("aa");
        String c=new String();

        //参数是字符数组
        char[] d={'a','b'};
        String e=new String(d);

        //参数是字节数组
        byte[] arr={3,4,6};
        String s=new String(arr);


    }
}
