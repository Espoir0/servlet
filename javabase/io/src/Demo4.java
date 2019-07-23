import java.io.File;

/**
 * 1.传递进来一个文件夹，打印该文件夹名称
 * 2.获取目录下的所有文件及文件夹
 * 3.遍历所有文件及文件夹，并判断字文件是不是文件夹，如果是则调用 该方法
 *
 */
public class Demo4 {
    public static void main(String[] args) {
        getFile(new File("E:\\test"));
    }

    private static void getFile(File file) {
        //System.out.println(file);
        File[] f=file.listFiles();
        for (File temp:f){
            if (temp.isDirectory()){
                getFile(temp);
            }
            else{
                if (temp.getName().toLowerCase().endsWith(".java")){
                    System.out.println(temp);
                }

            }

        }


    }
}
