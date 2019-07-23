package fileOutputStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * FileInputStream
 * int read(),读取文件的第一个字节并返回，读到文件的末尾返回 -1
 *
 */
public class Demo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\test\\append.txt");
        int len=0;
        while ((len=fis.read())!=-1){//用len记录每次读到的数据
            System.out.println((char) len);//吧字节形式转化为字符形式
            System.out.println(len);//输出文件中的每个字符的字节形式（十进制数字）
        }
        fis.close();
    }
}
