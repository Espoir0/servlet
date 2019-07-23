import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Test3 {
    public static void main(String[] args) throws FileNotFoundException {
        test();
    }

    private static void test() throws FileNotFoundException {
        System.out.println("aaa");
         PrintStream ps = new PrintStream("E:\\test\\aa.txt");
         //将系统的输出流改为ps 流，也就是 输出到文件中，
         System.setOut(ps);
        System.out.println("bbb");
         ps.close();

    }
}
