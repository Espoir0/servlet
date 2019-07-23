package demo;

import java.util.stream.Stream;

/**
 *  Stream 中的 filter(),对stream流中的数据进行过滤
 *      Stream<T> filter(Predicate<? super T> p)
 *      Predicate 依据规则进行判断
 */
public class Demo4 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("aaaaa", "ebbbb", "dddd", "eeeeee", "aaace");
        stream.filter(s-> s.length()==5 && s.contains("e")).forEach(s-> System.out.println(s));
    }
}
