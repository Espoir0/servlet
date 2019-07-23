package fileOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 *  int read(byte[] b) 从输入流中读取一定量的字节，将其存储在缓冲数组b中
 *  String()的构造方法
 *      Strign(byte[])
 *      Strign(byte[],offset,len),起始索引和长度
 *
 */
public class Demo4 {
    public static void main(String[] args) throws IOException {
        test2();
    }

    private static void test2() throws IOException {
        FileInputStream fis=new FileInputStream("E:\\test\\aa.txt");
        byte[] data=new byte[1024];//缓冲数组的长度设置为 1024
        int len=0;
        while ((len=fis.read(data) )!=-1){//len为有效长度
            //数据现在在data 数组中，将其转化为字符串，转化个数为从0开始到len
            System.out.println(new String(data,0,len));
        }


    }

    private static void test() throws IOException {
        FileInputStream fis=new FileInputStream("E:\\test\\aa.txt");
        byte[] data=new byte[8];
        int len=fis.read(data);  //len读取的有效字节个数   5
        System.out.println(len);

        System.out.println(new String(data));   //  adfaa
        System.out.println(Arrays.toString(data));  //数组没有读到的位置为0[97, 100, 102, 97, 97, 0, 0, 0]

        len=fis.read(data);  //len读取的有效字节个数  //-1
        System.out.println(len);

        fis.close();
    }
}
