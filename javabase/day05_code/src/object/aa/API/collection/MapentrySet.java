package object.aa.API.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapentrySet {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("aa",1);
        map.put("bb",2);
        map.put("cc",3);

        //for each遍历
        //Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        for (Map.Entry temp:map.entrySet()){
            System.out.println(temp.getKey());
            System.out.println(temp.getValue());
        }
        //迭代器遍历
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iter = entrySet.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next().getValue());
        }


    }
}
