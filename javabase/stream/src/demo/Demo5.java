package demo;

import java.util.stream.Stream;

/**
 * 将一个流中的数据转化到另一个流中使用 map()方法 （映射）
 * <R> Stream<R> map(Function<? super T,? extend R > mapper)
 *      将T类型的数据转换为R 类型的数据
 */
public class Demo5 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("11", "22", "33");

        stream.map(s->Integer.parseInt(s)).forEach(i-> System.out.println(i instanceof Integer));

        //Stream<Integer> stream1 = stream.map(s -> Integer.parseInt(s));  等价上面的代码
        //stream1.forEach(i-> System.out.println(i instanceof Integer));
    }}

