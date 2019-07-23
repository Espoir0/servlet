package buffer;

import java.io.*;

/**
 * 字节缓冲流
 */
public class Demo1 {
    public static void main(String[] args) throws IOException {
        //test();
        test2();

    }

    private static void test2() throws IOException {
        //缓冲流一次读一个字节
        long time=System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\c++primerplus.pdf"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\test\\copy2.pdf"));
        int len=0;
        while ((len=bis.read())!=-1){
            bos.write(len);
        }
        bos.flush();
        bos.close();
        long time2=System.currentTimeMillis();
        System.out.println(time2-time); //42s
    }

    private static void test() throws IOException {
        //缓冲流里面在设置缓冲数组
        long time=System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\c++primerplus.pdf"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\test\\copy.pdf"));
        int len=0;
        byte[] data=new byte[1024];
        while ((len=bis.read(data))!=-1){
            bos.write(data,0,len);
        }
        long time2=System.currentTimeMillis();
        System.out.println(time2-time); //1s

        bos.flush();
        bos.close();

    }
}
