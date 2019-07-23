package fileOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 字节输出流的步骤：
 *  1.创建一个 FileOutputStream对象
 *  2.调用对象的 write()方法，把数据写到文件中
 *  3.释放资源。
 *  创建一个流对象时，传入一个文件路径。该路径下，如果没有这个文件，会创建该文件。
 *  如果有这个文件，会清空这个文件的数据.
 */

public class Demo {
    public static void main(String[] args) throws IOException {
        test1();
        test2();
        test3();
    }

    private static void test3() throws IOException {
        /**
         * 写入字符的方法，把字符串转化为 字节数组，然后写入
         * idea默认编码utf-8 ，三个字节表示一个字符，GBK两个字节表示一个字符
         * -28, -67, -96, -27, -91, -67, -27, -111, -128]
         *
         */
        FileOutputStream fos=new FileOutputStream("E:\\test\\d.txt");
        byte[] bytes = "你好呀".getBytes();
        fos.write(bytes);
        System.out.println(Arrays.toString(bytes));
        fos.close();

    }

    private static void test2() throws IOException {
        /**
         * 向文件中一次写入多个字节
         *      如果第一个字节是正数(0-127),那么显示的时候会查询ASCII码表
         *      如果第一个字节是负数，那么第一个字节和第二个字节会组成一个字节显示，查询系统默认编码表（GBK）
         * 将bytes.length 长度的字节写入文件
         * 程序结束 。文件中显示  ABCDE，
         */

        FileOutputStream fos = new FileOutputStream(new File("E:\\test\\c.txt"));
        byte[] bytes=new byte[]{65,66,67,68,69};
        byte[] bytes2=new byte[]{-65,66,-67,68,69};//  文件显示   緽紻E
        fos.write(bytes2);

        //写出指定长度字节数组：
        // write(byte[] b, int off, int len) ,每次写出从off索引开始，len个字节
        fos.write(bytes,1,2);

        fos.close();
    }

    private static void test1() throws IOException {
        //FileOutputStream fos = new FileOutputStream("E:\\test\\output.txt");

        File file=new File("E:\\test\\output.txt");
        FileOutputStream fos = new FileOutputStream(file);
        //向文件中写入 100 需要写入3个字节
        fos.write(49);
        fos.write(48);
        fos.write(48);
        fos.close();
    }
}
