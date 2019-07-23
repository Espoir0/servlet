package demo;

import java.util.*;
import java.util.stream.Stream;

/**
 * 所有的Collection 集合都可以通过   stream()方法获取流
 *      default Stream<E> stream();
 *      Stream接口的静态方法 of() 可以获得数组对应的流
 *      static <T> Stream<T> of（T... values）values是一个可变参数，那么就可以传递一个数组
 *
 *      所有单列集合都可以直接获取 stream()
 */
public class Demo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        HashSet<String> set = new HashSet<>();
        Stream<String> stream1 = set.stream();

        HashMap<String, String> map = new HashMap<>();
        Set<String> key = map.keySet();                   // 把key转化为set
        Stream<String> stream2 = key.stream();

        Collection<String> values = map.values();         //value转化为collection
        Stream<String> stream4 = values.stream();

        Set<Map.Entry<String, String>> entries = map.entrySet();       //key,value同时转化为 set
        Stream<Map.Entry<String, String>> stream3 = entries.stream();


        //集合转化为  stream ,使用Stream的静态方法
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 56);

        String[] strings = new String[]{"aa","ff","cc"};
        Stream<String> stringsStream = Stream.of(strings);
    }
}
