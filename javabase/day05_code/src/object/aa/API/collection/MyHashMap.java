package object.aa.API.collection;

import java.util.HashMap;

public class MyHashMap {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        HashMap<Person3,String> map = new HashMap<>();
        map.put(new Person3("aa",3),"1");
        map.put(new Person3("bb",2),"2");
        map.put(new Person3("cc",3),"3");
        map.put(new Person3("cc",3),"4");

        System.out.println(map);

    }
}
