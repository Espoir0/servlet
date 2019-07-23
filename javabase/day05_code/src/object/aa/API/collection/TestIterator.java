package object.aa.API.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class TestIterator {

    public static void main(String[] args) {
        //集合是什么泛型，迭代器就是什么泛型
        Collection<String> col=new ArrayList<>();
        col.add("aa");
        col.add("bb");
        col.add("cc");
        col.add("sss");
        col.add("ee");
        Iterator<String> iter=col.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
