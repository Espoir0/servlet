package object.aa.API.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {
        //test1();
        test2();

    }

    private static void test2() {
        HashSet set=new HashSet();
        String s1="aaab";
        String s2=new String("aaab");
        String s3=new String("aaab");
        System.out.println(s1.hashCode()+"    "+s2.hashCode()+"  "+s3.hashCode());
        set.add("aaa");
        set.add(new String("aaa"));
        System.out.println(set);
        set.remove("aaa");
        System.out.println(set);


    }

    private static void test1() {
        HashSet<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        set.add("cc");//若元素与set内的元素重复，会覆盖掉原来的内容
        System.out.println(set);

        Iterator<String> iter=set.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next());
        }
        System.out.println();
        for(String temp:set){
            System.out.print(temp);
        }
    }
}
