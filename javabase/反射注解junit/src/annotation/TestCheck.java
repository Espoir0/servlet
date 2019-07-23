package annotation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 简单的测试框架
 *  主方法执行后，会自动检测 （加了注解的所有方法），判断是否有异常，并记录到文件中
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {
        //创建计算机对象
        Calculator c=new Calculator();
        //获取字节码文件
        Class cls=c.getClass();
        //获取所有方法

        Method[] methods =cls.getMethods();
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));
        int num=0;//出现异常的次数

        //判断方法上是否有check注解
        //有，执行，并捕获异常
        for (Method method : methods) {
            if(method.isAnnotationPresent(Check.class)){
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    num++;
                    bw.write(method.getName()+"方法出现异常了");
                    bw.newLine();
                    bw.write("异常的名称："+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因："+e.getCause().getMessage());
                    bw.newLine();
                    bw.write(".....");


                }
            }
        }

        bw.write("本次测试该出现"+num+"次异常");
        bw.flush();
        bw.close();

    }
}
