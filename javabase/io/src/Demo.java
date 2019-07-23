import java.io.File;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        test5();
    }

    private static void test5() {
        /**
         * mkdir()   创建单个文件夹
         * mkdirs() 创建多级文件夹
         */
        File f=new File("E:\\test\\a.txt");
        f.mkdir();//创建了  a.txt文件夹
        f.delete();   //删除文件或者文件夹
    }

    private static void test4() throws IOException {
        /**
         * f.creatNewFile()
 *                 只能创建文件不能创建文件夹
 *                 文件不存在，创建成功返回 true
 *                 文件存在，创建失败， false
 *                 创建文件的路径必须存在，否则抛异常
 *
         */
        File f=new File("E:\\test\\creatfile.txt");
        File f2=new File("E:\\test\\creatfil");  //也创建了文件，而不是文件夹
        f.createNewFile();
        f2.createNewFile();
    }

    private static void test3() {
        File f=new File("E:\\test\\3.txt");
        System.out.println(f.exists());   //true

        //路径必须是存在的，否则返回 false
        if (f.exists()){
            System.out.println(f.isDirectory());   //false
            System.out.println(f.isFile());    //true
        }

    }

    private static void test2() {
        /**
         * 测试File类的方法
         */
        File f=new File("E:\\test\\3.txt");


        System.out.println(f.getPath());          //获取构造方法中传递的路径  E:\test\3.txt
        System.out.println(f.getAbsolutePath());  //获取文件的绝对路径       E:\test\3.txt
        System.out.println(f);                    //重写了 toString()  返回的是 getPath(); E:\test\3.txt
        System.out.println(f.getName());           //返回路径末端文件或者文件夹的名字   //3.txt
        System.out.println(f.length());           //获取文件的大小，若文件不存在返回 0, // 130

        File f2=new File("r");       //
        System.out.println(f2.getPath());           //  获得相对路径   r\3.txt
        //E:\code\java\javabase\r\3.txt  获取绝对路径，获得项目路径+ 相对路径
        System.out.println(f2.getAbsolutePath());   //E:\code\java\javabase\r
        System.out.println(f2.getName());       //r
        System.out.println(f2.length());        //文件夹不存在大小

    }


    private static void test1() {

/**
 *       路径名称不区分大小写，
 *       两个\表示一个反斜杠
 *
 *       构造方法：
 *       File(String pathname)
 *       File(String parent,String child)
 *       File(File parent,String child)
 */

        String path="E:\\test";
        String fileName="3.txt";
        File f=new File(path,fileName);  //表示一个文件对象

        String path2="E:\\test\\3.txt";
        File f2=new File(path2);

        File f3=new File(new File("E:\\test"),"3.txt");

    }
}

