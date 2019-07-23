package test;

import java.io.IOException;

public class TestThrows {
    public static void main(String[] args) throws IOException {
        test("a.tx");
    }

    private static void test(String fileName) throws IOException {
        //编译期异常，throw的异常必须 throws 或着 try-catch
        /**
         * throw 的异常是编译期异常的时候必须。在方法声明的地方throws或者 try-catch
         * 可以throws多个异常，如果异常为父子关系，直接throws 父类异常即可
         *
          */


        if(!fileName.endsWith(".txt")){
            throw new IOException("文件后缀名不是 .txt");
        }

        if(!("c:\\a.txt".equals(fileName))){
            throw new IOException("文件名不合法");
        };

    }

}
