package test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Test4 {
    public void test1() throws IOException{
    }
    public void test2() throws IOException{
    }

    public void test4() { }
}
class A extends Test4{
    //抛出和父类相同的异常或者父类异常的子类或者不抛出异常
    public void test1() throws IOException, FileNotFoundException { }
    public void test2() throws IOException { }

    //如果父类没有抛出异常，子类有异常时，必须try-catch
    public void test4()  {
        try {
            throw new Exception();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
