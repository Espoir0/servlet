package demo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Stream流式编程
 */

public class Demo1 {
    public static void main(String[] args) {
        test();
        test2();
    }

    private static void test2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("舒敏");
        list.add("王菲");
        list.add("舒淇");
        list.add("迪丽热巴");
        list.add("嘻嘻嘻");

        //流式编程 filter参数是(Predicate接口，函数式接口，test()方法依据条件进行判断，可用lambda简写)
        list.stream().filter(name-> name.startsWith("舒"))
                .filter(name->name.length()==2)
                .forEach(name -> System.out.println(name));  //Consumer接口消费型接口
    }

    private static void test() {
        ArrayList<String> list = new ArrayList<>();
        list.add("舒敏");
        list.add("王菲");
        list.add("舒淇");
        list.add("迪丽热巴");
        list.add("嘻嘻嘻");
        ArrayList<String> list2 =new ArrayList<>();

        for(String temp:list){
            if(temp.length()==2 && temp.startsWith("舒")){
                list2.add(temp);
            }
        }

        Iterator<String> iter=list2.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}

