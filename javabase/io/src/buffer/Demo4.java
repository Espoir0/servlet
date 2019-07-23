package buffer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo4 {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        try(
                BufferedReader br=new BufferedReader( new FileReader("E:\\test\\gbk.txt"));) {

            int len=0;
            char[] data=new char[1024];
            while ((len=br.read(data))!=-1){
                System.out.println(new String(data,0,len));
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
