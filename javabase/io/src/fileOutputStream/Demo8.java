package fileOutputStream;

import java.io.FileWriter;
import java.io.IOException;

/**
 * jdk1.7之前的捕获异常
 */
public class Demo8 {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        FileWriter fw= null;
        try {
            fw = new FileWriter("E:\\test\\test.txt");
            for (int i = 0; i < 10; i++) {
                fw.write("helloworld"+i);
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {

            //防止空指针异常
            if(null!=fw) {
                try {
                    fw.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }

        }
    }
}
