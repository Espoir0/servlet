package object.aa.API.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo2 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("aa");
        list.add("bb");
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        show(list);
        show(list1);

    }

    private static void show(List<?>  list) {
        Iterator<?> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


}
