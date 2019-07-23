package use;

import java.util.function.Function;

/**
 * 将一种数据类型转化为其他数据类型
 *  将字符串转化为整型
 */
public class FunctionApp {
    public static void main(String[] args) {
        System.out.println(change("1",s->Integer.parseInt(s)));
    }

    private static Integer change(String s, Function<String,Integer> fun) {
        return fun.apply(s);

    }


}
