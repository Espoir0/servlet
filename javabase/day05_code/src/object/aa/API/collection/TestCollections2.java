package object.aa.API.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestCollections2 {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        ArrayList<Person5> list = new ArrayList<>();
        Collections.addAll(list,new Person5(35,"aa"),new Person5(39,"aa"),new Person5(29,"cc"));
        Collections.sort(list, new Comparator<Person5>() {
            @Override
            public int compare(Person5 o1, Person5 o2) {
                //return 0;
                int result=o1.age-o2.age;
                if(result==0){
                    result=o1.name.charAt(0)-o2.name.charAt(0);
                }
                return result;
            }
        });

        System.out.println(list);
    }
}
