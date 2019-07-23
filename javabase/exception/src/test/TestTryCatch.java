package test;

import java.io.IOException;

/**
 * 调用方法不继续throws 的时候，就要用try-catch 捕获异常
 * try{
 *
 * }catch(异常类名 e){
 *
 * }
 * try 中可能抛出多个异常，需要多个catch 来捕获异常
 * 2.try中产生了异常，执行catch中的异常处理，然后继续执行try-catch之后的代码
 */

public class TestTryCatch {
    public static void main(String[] args) {
        try {
            test("c:\\a.tx");
        } catch (IOException e) {
            System.out.println("文件名不是 .txt结尾");
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            System.out.println(e);
        }finally {
            //无论是否出现异常都对执行。和try 一起使用
            //一般用于资源释放，无论是否出现异常都要进行资源释放
            System.out.println("finally");
        }
        System.out.println("try-catch 之后的代码");
    }

    private static void test(String fileName) throws IOException {

        if(!fileName.endsWith(".txt")){
            throw new IOException("文件后缀名不是 .txt");
        }

        if(!("c:\\a.txt".equals(fileName))){
            throw new IOException("文件名不合法");
        };

    }

}
