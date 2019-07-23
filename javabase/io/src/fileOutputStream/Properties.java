package fileOutputStream;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

public class Properties {
    public static void main(String[] args) {
        //test();
        //test2();
        test3();
    }

    private static void test3() {
        //从文件中加载键值对，键值连接符 可以使 = 空格等
        //被  # 注释的内容不会读取，读取到的内容都是字符串
        java.util.Properties prop=new java.util.Properties();
        try {
            //一般用字符流，字节流会乱码
            prop.load(new FileReader("E:\\test\\bb.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {
            String value=prop.getProperty(key);
            System.out.println(key+"="+value);
        }
    }

    private static void test2() {
        //字符流不能写中文
        java.util.Properties prop =new java.util.Properties();
        prop.setProperty("哈哈","19");
        prop.setProperty("嘿嘿","18");
        prop.setProperty("嘻嘻","20");

        try(
                FileWriter fw=new FileWriter("E:\\test\\bb.txt");
                FileReader fr=new FileReader("E:\\test\\aa.txt")){

            prop.store(fw,"save daa");
            char[] data=new char[1024];
            int len=0;
            while ((len=fr.read(data))!= -1){
                String s = new String(data, 0, len);
                System.out.println(s);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void test() {
        //字节流不能写中文,覆盖写
        java.util.Properties prop =new java.util.Properties();
        prop.setProperty("哈哈","19");
        prop.setProperty("嘿嘿","18");
        prop.setProperty("嘻嘻","20");

        try(
            FileOutputStream fos = new FileOutputStream("E:\\test\\aa.txt")){

            prop.store(fos,"save daa");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
