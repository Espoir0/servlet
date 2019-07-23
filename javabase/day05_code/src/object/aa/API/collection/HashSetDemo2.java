package object.aa.API.collection;

import java.util.HashSet;

public class HashSetDemo2 {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        //set里面存储自定义对象的时候必须重写equals();和hashCode();方法
        HashSet<Person3> set = new HashSet<>();
        Person3 p1 = new Person3("aa",12);
        Person3 p2 = new Person3("aa",12);
        Person3 p4 = new Person3("aa",34);
        Person3 p3 = new Person3("bb",15);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);
        System.out.println(set);
    }
}
