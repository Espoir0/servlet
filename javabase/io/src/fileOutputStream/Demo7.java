package fileOutputStream;

        import java.io.FileWriter;
        import java.io.IOException;

/**
 * FileWriter 是先把字符写到内存中，
 * 一般都需要flush()
 * close()关闭的时候会把所有内存中的字符flush()到硬盘中
 *
 *         //FileWriter fw2 = new FileWriter("E:\\test\\writer.txt",true);追加写
 *
 *  win  \r\n
 *  linux /n
 *  max  /r
 */

public class Demo7 {
    public static void main(String[] args) throws IOException {
        test();
        test1();
    }

    private static void test1() throws IOException {
        FileWriter fw = new FileWriter("E:\\test\\writer2.txt");
        for (int i = 0; i < 5; i++) {
            fw.write("hello world"+i+"\r\n");
        }
        fw.write("卡机房");
        fw.flush();//把内存缓冲区的数据刷新到文件中
        fw.close();
    }


    private static void test() throws IOException {
        FileWriter fw = new FileWriter("E:\\test\\writer.txt");
        //FileWriter fw2 = new FileWriter("E:\\test\\writer.txt",true);追加写

        //写多个字符
        char[] data1={'a','b','c','d'};
        fw.write(data1);
        //写指定长度的字符
        fw.write(data1,2,1);

        //写字符串
        fw.write("faksdfj机房灵泛");

        //写指定长度的字符串
        fw.write("dfasdkf",0,4);

        fw.close();
    }
}
