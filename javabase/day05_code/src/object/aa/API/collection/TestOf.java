package object.aa.API.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestOf {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        //添加的时候不能有相同的元素
        Map<String,Integer> map=Map.of("aa",1,"bb",3,"cc",4);
        System.out.println(map);
        //map.put("aa",3);  不能再添加新的元素

        List<String> list=List.of("aa","bb","aa");
        System.out.println(list);

        Set<String> set=Set.of("aa","bb","x");//不能有相同的元素
        System.out.println(set);
    }
}
