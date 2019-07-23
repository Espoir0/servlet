package fileOutputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 字节流读取中文的时候，会乱码
 *  utf-8  3个字节表示一个字符
 *  gbk    2个字节表示一个字符
 *  
 *  英文字符只占一个字节，所以英文字符没问题
 *  而中文读的时候每次只读到了 1/3个字符，所以乱码
 * 文件的复制
 */
public class Demo5 {
    public static void main(String[] args) throws IOException {
        copyFile();
        copyFile2();
    }

    private static void copyFile2() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\test\\aa.txt");
        FileOutputStream fos = new FileOutputStream("E:\\test\\cc.txt");

        int len=0;
        while ((len=fis.read())!= -1){
            fos.write(len);
        }

    }

    private static void copyFile() throws IOException {
        FileInputStream fis = new FileInputStream("E:\\test\\aa.txt");
        FileOutputStream fos = new FileOutputStream("E:\\test\\bb.txt");

        byte[] data=new byte[1024];
        int len=0;
        while ((len=fis.read(data))!= -1){
            fos.write(data,0,len);
        }


        fos.close();
        fis.close();
    }
}
