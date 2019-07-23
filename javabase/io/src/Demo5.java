import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class Demo5 {
    public static void main(String[] args) {
        getFiles1(new File("E:\\test"));
        getFiles2(new File("E:\\test"));
    }

    private static void getFiles2(File dir) {
        //FilenameFilter过滤器，匿名内部类实现
       /* File[] f=dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isDirectory() || name.toLowerCase().endsWith(".java");
            }
        });*/

       //lambda表达式实现，FileFilter只有一个抽象方法，
        File[] f=dir.listFiles((d,name)->new File(d,name).isDirectory() || name.toLowerCase().endsWith(".java"));

        for (File temp:f){
            if (temp.isDirectory()){
                getFiles1(temp);
            }else {
                System.out.println(temp);
            }
        }
    }


    private static void getFiles1(File dir) {
        //FileFilter过滤器
        /*File[] f=dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().toLowerCase().endsWith(".java") || pathname.isDirectory();
            }
        });*/

        //lambda表达式实现
        File[] f=dir.listFiles(file-> file.isDirectory() || file.getName().toLowerCase().endsWith(".java"));
        for (File temp:f){
            if (temp.isDirectory()){
                getFiles1(temp);
            }else {
                System.out.println(temp);
            }
        }

    }
}
