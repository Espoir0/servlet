package demo;

import java.util.ArrayList;

/**
 * void forEach(Consumer <? super T> action)  方法
 *     终结方法，用来遍历流中的数据，
 *     Consumer 消费型接口
 */
public class Demo3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("aa");
        list.add("cc");
        list.add("dd");
        list.add("ee");
        list.stream().forEach(s-> System.out.println(s));
    }
}
