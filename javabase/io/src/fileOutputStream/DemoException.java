package fileOutputStream;

import java.io.*;

public class DemoException {
    public static void main(String[] args) {
        //test();
        test2();

    }

    private static void test2() {
        //jdk1.7特性，将所需要的流放入try()中，结束之后自动关闭流，不用手动关闭
        //复制图片
        try (
                FileInputStream fis = new FileInputStream("E:\\test\\photo.jpg");
                FileOutputStream fos = new FileOutputStream("E:\\Test\\photo2.jpg")) {

            byte[] data = new byte[1024];
            int len = 0;
            while ((len = fis.read(data)) != -1) {
                fos.write(data, 0, len);

            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    private static void test() {
        //jdk1.7特性，将所需要的流放入try()中，结束之后自动关闭流，不用手动关闭
        try (
            FileReader fr = new FileReader("E:\\test\\aa.txt");
            FileWriter fw = new FileWriter("E:\\Test\\bb.txt")) {

            char[] data = new char[1024];
            int len = 0;
            while ((len = fr.read(data)) != -1) {
                fw.write(data, 0, len);

            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
