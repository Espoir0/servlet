package method;

/**
 * 定义一个函数式接口，有个print方法
 * 定义一个打印字符串的方法，参数是函数式接口，传递lambdak
 * 方法引用
 */
public class Demo1 {
    public static void print(Printable<String> p){
        p.print("hello world");
    }

    public static void main(String[] args) {
        //lambda
        print(s-> System.out.println(s));
        print(System.out::println);
    }

}


