package buffer;

import java.io.*;

/**
 * 将文件转化为指定格式的编码
 */
public class Demo6 {
    public static void main(String[] args) throws IOException {
        transcoding();
    }

    private static void transcoding() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\test\\gbk.txt"),"gbk");
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("E:\\test\\utf-8.txt"));
        InputStreamReader isr2 = new InputStreamReader(new FileInputStream("E:\\test\\utf-8.txt"));


        int len=0;
        char[] data=new char[1024];
        while ((len=isr.read(data)) != -1){
            System.out.println(new String(data,0,len));
            osw.write(data,0,len);
        }
        osw.close();
        isr.close();

        char[] data2=new char[1024];
        while ((len=isr2.read(data2)) != -1){
            System.out.println(new String(data,0,len));
        }

    }
}
