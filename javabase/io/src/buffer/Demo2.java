package buffer;

import java.io.*;


public class Demo2 {
    public static void main(String[] args) throws IOException {
        test();
        testBuffer();
        testBuffer2();
        testBufferReader();
    }

    private static void testBuffer() throws IOException {
        //缓冲流一次读一个字节
        long time=System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\c++primerplus.pdf"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\test\\copybyte.pdf"));
        int len=0;
        while ((len=bis.read())!=-1){
            bos.write(len);
        }
        bos.flush();
        bos.close();
        long time2=System.currentTimeMillis();
        System.out.println("byte:"+(time2-time)); //42s
    }

    private static void testBuffer2() throws IOException {
        //缓冲流里面在设置缓冲数组
        long time=System.currentTimeMillis();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\c++primerplus.pdf"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\test\\copybytes.pdf"));
        int len=0;
        byte[] data=new byte[1024];
        while ((len=bis.read(data))!=-1){
            bos.write(data,0,len);
        }
        long time2=System.currentTimeMillis();
        System.out.println("bytes:"+(time2-time)); //1s

        bos.flush();
        bos.close();

    }

    private static void testBufferReader() throws IOException {
        /**
         * 字符流
         * 自定义缓冲数组
         */
        long start=System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader("E:\\c++primerplus.pdf"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\test\\copyread.pdf"));

        int len=0;
        char[] data=new char[1024];
        while ((len=br.read(data))!=-1){
            bw.write(data,0,len);
        }
        bw.flush();
        bw.close();
        long end=System.currentTimeMillis();
        System.out.println("read:"+(end-start));
    }

    private static void test() throws IOException {
        /**
         * 字符缓冲流
         *    字符缓冲流写到内存中，需要flush
         *    bw.newLine()换行
         */
        long start=System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new FileReader("E:\\c++primerplus.pdf"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\test\\copyreadline.pdf"));

        String line=null;
        //readline() 方法返回一行读到的字符串，字符串不包含 换行符
        while ((line=br.readLine())!= null){
            bw.write(line);
            bw.newLine();//加车换行
        }
        bw.flush();
        bw.close();
        long end=System.currentTimeMillis();
        System.out.println("readline"+(end-start));
    }
}
