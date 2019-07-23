package use;

import java.util.function.Supplier;

/**
 * Supplier<T>,接口包含一个无参的方法， T get(),来获取一个 泛型参数指定类型的对象
 *
 * 称为生产型接口
 */

public class SupplierAPP {
    public static void main(String[] args) {
        getString(new Supplier<String>(){
            @Override
            public String get(){
                return "hello";
            }
        });

        getString(()->{
            return "hello";
        });

        //lambda表达式  实际就是重写接口中的get()方法
        getString(()-> "hello");
    }

    private static String getString(Supplier<String> sup) {
        return sup.get();
    }
}
