package object.aa.API.collection;

import java.util.ArrayList;
import java.util.Collections;

public class TestCollection {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        ArrayList<String> list = new ArrayList<String>();

        Collections.addAll(list,"aa","bb","cc");//在集合中添加多个元素
        Collections.shuffle(list);//打乱集合中的元素
        Collections.sort(list);//  给集合中的元素按升序排序，集合中的元素类型必须实现Comparable接口，重写compareTo方法；

        ArrayList<Person1> list2=new ArrayList<>();
        Collections.addAll(list2,new Person1(13,"aa"),new Person1(9,"bb"),new Person1(19,"cc"));
        System.out.println(list2);
        Collections.sort(list2);
        System.out.println(list2);

    }
}
