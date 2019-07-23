package fileOutputStream;

        import java.io.FileReader;
        import java.io.IOException;

/**
 * 字符流，不管是中文还是英文每次都读取一个字符
 */

public class Demo6 {
    public static void main(String[] args) throws IOException {
        //test();
        test1();
    }

    private static void test1() throws IOException {
        FileReader fr=new FileReader("E:\\test\\aa.txt");
        int len=0;//每次读到的有效字符个数
        char[] data=new char[1024];
        while ((len=fr.read(data)) != -1){
            System.out.print(new String(data,0,len));
        }
        System.out.println();
        fr.close();
    }

    private static void test() throws IOException {
        FileReader fr=new FileReader("E:\\test\\aa.txt");
        int len=0;
        while ((len=fr.read()) != -1){
            System.out.print((char) len);
        }

        fr.close();
    }
}
