package object.aa.inner_class;

import java.util.ArrayList;
import java.util.List;

public class TestInterfaceArgument {
    public static void main(String[] args) {
        List<String> list =new ArrayList<>();
        list=addSomething(list);
        System.out.println(list);
    }

    private static List<String> addSomething(List<String> list) {
        list.add("苹果");
        list.add("橘子");
        list.add("柚子");
        return list;
    }
}
