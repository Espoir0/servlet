package use;

import java.util.function.Consumer;

/**
 * Consumer接口，消费型接口。
 */
public class ConsumerApp {
    public static void main(String[] args) {
        //输出字符串
        method("aa", (s) -> System.out.println());


        //反转字符串
        method2("asdfghjkjl;", (String s) -> {
            String str = new StringBuilder(s).reverse().toString();
            System.out.println(str);
        });
    }

        private static void method (String s, Consumer < String > con){
            con.accept(s);
        }


    private static void method2(String s, Consumer<String> consummer) {
        consummer.accept(s);
    }

}