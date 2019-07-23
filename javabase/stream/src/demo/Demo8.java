package demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 两个集合
 */
public class Demo8 {
    public static void main(String[] args) {
        List<String> list = List.of("aa","ccc","ee","ddd","fff","ed");
        List<String> list2 = List.of("zz","eecc","evv","dtttd","nfff","nmd");


        test1(list);
        test2(list);
        test3(list2);
        test4(list2);

        test5(list,list2);

    }

    //合并两个list
    private static void test5(List<String> list,List<String> list2) {
        ArrayList<String> list1 = new ArrayList<>();
       /* for(int i=0;i<list.size();i++){
            list1.add(list.get(i));
        }
        for(int i=0;i<list2.size();i++){
            list1.add(list.get(i));
        }
        System.out.println(list1);*/

       list1.addAll(list);
       list1.addAll(list2);

        ArrayList<Person> list3 = new ArrayList<>();
        Iterator<String> iter=list1.iterator();
        while(iter.hasNext()){
            list3.add(new Person(iter.next()));
        }
        System.out.println(list3);

    }

    //不要前两个元素，存储到新的集合中
    private static void test4(List<String> list) {
        ArrayList<String> list1 = new ArrayList<>();

        for (int i=2;i<list.size();i++){
            list1.add(list.get(i));
        }
        System.out.println(list1);

    }

    //首字母为e的存储到心机和中
    private static void test3(List<String> list) {
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : list) {
            if(s.startsWith("e")){
                list1.add(s);
            }
        }
        System.out.println(list1);

    }

    //只要前三个
    private static void test2(List<String> list) {
        ArrayList<String> list1 = new ArrayList<>();
        for (int i=0;i<3;i++){
            list1.add(list.get(i));
        }
        System.out.println(list1);
    }

    //只要长度为三的
    private static void test1(List<String> list) {
        ArrayList<String> list1 = new ArrayList<>();
        for (String s : list) {
            if(s.length()==3){
                list1.add(s);
            }
        }
        System.out.println(list1);
    }
}

class Person{
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
