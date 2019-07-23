package object.aa.API.collection;

import java.util.LinkedHashSet;

public class LinedHashSetTest {
    public static void main(String[] args) {
        test2();

    }

    private static void test2() {
        LinkedHashSet linedHashSet = new LinkedHashSet();
        linedHashSet.add("aa");
        linedHashSet.add("bb");
        linedHashSet.add("cc");
        linedHashSet.add("dd");
        System.out.println(linedHashSet);

    }
}
