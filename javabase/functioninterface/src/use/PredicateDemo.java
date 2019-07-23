package use;

import java.util.function.Predicate;

/**
 * Predicate 接口：对某种数据类型,依据条件进行判断，返回值为 true / false
 *   public abstract boolean test();
 *
 */
public class PredicateDemo {
    public static void main(String[] args) {
        System.out.println(method("aabbcce",(s)-> s.contains("e")));  //true
    }

    private static boolean method(String s, Predicate<String> pre) {
        return pre.test(s);
    }
}
