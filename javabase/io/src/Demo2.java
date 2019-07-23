import java.io.File;
import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) {
        File f=new File("E:\\test");
        File[] files=f.listFiles();   //返回目录下的所有文件对象构成的数组
        String[] filenames=f.list();  //返回所有文件名构成的数组
        System.out.println(Arrays.toString(filenames));
        System.out.println(Arrays.toString(files));  //

    }
}
