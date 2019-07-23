package object.aa.API.collection;

import java.util.HashMap;

/**
 * Map中的常用方法
 * 1. public V put(K key, V value) 如果Key值已存在，返回被替换的value
 * 2. public V remove(Object key)   返回remove掉的key对应的value值
 *          不存在 key 值时 返回null
 * 3. public V get(K key,V Value) key存在返回对应的value,key不存在返回Null
 * 4. boolean containsKey()    key存在返回true
 *
 */

public class TestMap {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2,"aa");
        map.put(3,"bb");
        map.put(4,"cc");
        String s=map.put(4,"dd");

        //2.
        String v=map.remove(8);


    }
}
