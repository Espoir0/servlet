package use;

import java.util.function.Function;

/**
 * 将字符串转化为整数，然后 +10 在转化为字符串
 *  andThen()方法
 */
public class FunctionAPP2 {
    public static void main(String[] args) {
        System.out.println(change("11",s->Integer.parseInt(s),i-> ""+(i+10)));
    }

    private static String change(String s, Function<String,Integer> fun,Function<Integer,String> fun2) {
        //Integer i=fun.apply(s);
        //return fun2.apply(i);
        return fun.andThen(fun2).apply(s);
    }
}
