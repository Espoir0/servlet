import java.io.File;

/**
 * java.io.File 类是文件和目录/文件夹路径名的抽象表示，
 * 用于文件和目录的创建、查找和删除,获取，遍历文件夹
 * file 文件
 * directory 目录/文件夹
 * path 路径
 *
 *
 *
 * static String pathSeparator   win ;  linux :
 *           与系统有关的路径分隔符，是一个字符串。 pathSeparatorChar+""
 * static char pathSeparatorChar
 *           与系统有关的路径分隔符。是一个字符
 * static String separator    win \    linux  /
 *           与系统有关的默认名称分隔符，是一个字符串。 separatorChar+""
 * static char separatorChar
 *           与系统有关的默认名称分隔符
 */
public class TestFile {
    public static void main(String[] args) {
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
        System.out.println(File.pathSeparatorChar);
        System.out.println(File.separatorChar);
    }

}

