package object.aa.API.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class List2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");
        ArrayList list1=new ArrayList();
        list1.add("a");

        System.out.println(list.get(3));

        String remove = list.remove(3);
        System.out.println(remove);

        list.set(2,"ee");//set的时候只能在已有索引中设置，

        list.add(3,"ff");//add的时候，可以设置的索引是 list.size()+1 这样就add到了最后面
        System.out.println(list);

        //遍历list的三种方式
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
        System.out.println();
        //foreach
        for (String temp:list) {
            System.out.print(temp);
        }
        System.out.println();


        //迭代器
        Iterator<String> iter=list.iterator();
        while(iter.hasNext()){
            System.out.print(iter.next());
        }
        System.out.println();
    }
}
