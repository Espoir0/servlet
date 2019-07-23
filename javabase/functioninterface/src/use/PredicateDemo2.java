package use;

import java.util.function.Predicate;

/**
 * predicate 的and（） or()
 *  需求判断一个字符串 长度是否大于五，且是否包含 “a”
 *
 *           pre1.test(s) && pre2.test(s)   <=>pre1.and(pre2).test(s);  与
 *        // pre1.test(s) || pre2.test(s);  <=>pre.or(pre2).test(s);    或
 *
 *         //pre.negate().test();  <=>  ! pre.test();  取反
 */
public class PredicateDemo2 {
    public static void main(String[] args) {
        System.out.println(method("asdf",s ->s.contains("a"),s->s.length()<5));
    }

    private static boolean method(String s, Predicate<String> pre1,Predicate<String> pre2) {
       //return  pre1.test(s) && pre2.test(s); 这两行等价
       return pre1.and(pre2).test(s);

     }
}
