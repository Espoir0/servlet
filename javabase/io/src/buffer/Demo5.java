package buffer;

import java.io.*;

/**
 * 转化流，转换输入，转换输出
 */

public class Demo5 {
    public static void main(String[] args) throws IOException {
        //writeUTF8();
        readGBK();
    }

    private static void readGBK() throws IOException {
        //创建转换输入流  参数是：字节输入流和编码表名称  ，编码表名称和文件编码格式相同
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\test\\gbk.txt"), "gbk");

        int len=0;
        char[] data=new char[1024];
        while ((len=isr.read(data))!=-1){
            System.out.println(new String(data,0,len));

        }
        isr.close();
    }

    private static void writeUTF8() throws IOException {
        //创建转换流
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\test\\gbk.txt"),"gbk");

        osw.write("我是一个黑客");//将字符转化为字节并存储到缓冲区中（编码）
        osw.flush();//把缓冲区的字节刷新到文件中
        osw.close();

        FileReader fr = new FileReader("E:\\test\\utf_8.txt");

        int len=0;
        char[] data=new char[1024];
        while ((len=fr.read(data))!=-1){
            System.out.println(data);
        }
        fr.close();
    }
}
