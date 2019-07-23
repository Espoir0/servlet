package cn.aa.day04.testfinal;

public class Test {
    public static void main(String[] args) {
        final Student s = new Student("aa");
        //s =new Student("bb"); //错误写法，final修饰的引用类型变量不可变
        s.name="bb";
        System.out.println(s.name);
    }
}
