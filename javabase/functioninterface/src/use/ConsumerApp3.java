package use;
/**
 * Consumer接口  消费型接口，无返回值，对参数进行操作
 */
import java.util.function.Consumer;

public class ConsumerApp3 {
    public static void main(String[] args) {
        method("ZXCVbnm",
                (t) -> {
                    System.out.println(t.toLowerCase());
                },
                (t) -> {
                    System.out.println(t.toUpperCase());
                });
    }

    private static void method(String s, Consumer<String> con1,Consumer<String> con2) {
        //  con1.accept(s);
        //  con2.accept(s);
        //  使用 andThen 方法把两个Consumer接口连接到一起，然后进行消费
        con1.andThen(con2).accept(s);
    }
}
