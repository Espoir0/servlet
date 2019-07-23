package object.aa.API;

import java.util.Objects;

public class TestEquals {
    public static void main(String[] args) {
        Person person = new Person(10,"aa");
        Person person2 = new Person(15,"aa");

        System.out.println(person.equals(person2));

        String s1="aa";
        String s2=null;
        System.out.println(Objects.equals(s1,s2));
    }
}
