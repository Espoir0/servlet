package object.aa.API.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 遍历Map的两种方式
 * 1.keySet(),将map的所有key值转化为set集合，
 * 2.遍历set集合找到所有key
 * 3.map.get(key)
 */

public class TestkeySet {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("苹果",5);
        map.put("橘子",6);
        map.put("梨",7);

        //foreach遍历
       // Set<String> set=map.keySet();
        for (String temp:map.keySet()){
            System.out.println(map.get(temp));
        }

        //迭代器
        Set<String> set=map.keySet();
        Iterator<String> iter=set.iterator();
        while (iter.hasNext()){
            System.out.println(map.get(iter.next()));
        }



    }
}
