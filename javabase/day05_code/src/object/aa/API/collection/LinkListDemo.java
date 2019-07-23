package object.aa.API.collection;

import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList implement List接口
 * 底层是一个链表，查询慢，增删快
 * 有许多关于首尾的方法
 */
public class LinkListDemo {
    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList();
        //增加
        list.add("aa");
        list.add("bb");
        list.add("cc");
        System.out.println(list);
        list.addFirst("first");
        System.out.println("getFirst"+list.getFirst());
        list.push("pushfirst");//等价addFirst()
        list.addLast("last");
        System.out.println("getLast:"+list.getLast());

        list.removeFirst();
        list.removeLast();
        System.out.println(list.pop()+"pop");//等价 removeFirst()
        System.out.println(list);

    }
}
