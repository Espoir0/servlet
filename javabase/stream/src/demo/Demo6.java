package demo;

import java.util.stream.Stream;

/**
 * count（） 方法，终结方法a
 *      统计流中的元素个数
 */
public class Demo6 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,4,5,6,7,8,9,0};

        Stream<Integer> s=Stream.of(arr);
        long count =s.count();
        System.out.println(count);
    }
}
