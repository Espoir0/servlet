import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        test();
    }

    private static void test() throws FileNotFoundException {
        PrintStream ps = new PrintStream("E:\\test\\aaa.txt");
        ps.write(93);
        ps.println(93);
        ps.print(93);

        ps.close();


    }
}


