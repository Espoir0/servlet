package demo;

import java.util.stream.Stream;

/**
 *  Stream<T> limit(long maxsize)
 *      对流中的元素进行截取，只取maxsize个 返回值是一个新的流
 *
 *      skip(n)   跳过前n个元素，返回剩下元素组成的流
 *
 *      concat(Stream ,Stream)连接两个流
 */

public class Demo7 {
    public static void main(String[] args) {
        method();
        method1();
        method2();
    }

    private static void method2() {
        Stream stream=Stream.of("aa","bb","cc","dd");
        Stream stream2=Stream.of("aa","bb","cc","dd");
        Stream<String> stream3=Stream.concat(stream,stream2);
        stream3.forEach(s-> System.out.print(s));

    }

    private static void method1() {
        Stream stream=Stream.of("aa","bb","cc","dd");
        //跳过前2个元素，返回剩下元素的流
        Stream<String> stream1=stream.skip(2);
        stream1.forEach(s-> System.out.println(s));

    }

    private static void method() {
        Stream stream=Stream.of("aa","bb","cc","dd");
        Stream<String> stream1=stream.limit(2);

        stream1.forEach(s-> System.out.println(s));
    }
}
