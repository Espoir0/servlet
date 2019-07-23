package annotation;

import java.lang.reflect.Method;

@MyAnnotation(className = "annotation.Animal",methodName = "run")
public class ReflectTest {
    public static void main(String[] args) throws Exception {

    //不改变该类的代码，可以创建任意类对象，执行任一方法

    //1.解析注解
    //1.1获取该类的字节码文件对象

    Class<ReflectTest> cls=ReflectTest.class;
    //2.获取类上标注的注解对象

    //这行代码在内存中生成了一个注解接口的实现类，并创建了实现类的实例
    MyAnnotation an=cls.getAnnotation(MyAnnotation.class);
    /*
public class MyAnnotationImpl implements MyAnnotation{
    @Override
    public String className(){
        return "annotation.Animal";
    }

    @Override
    public String methodName() {

        return "run";
    }
}
*/


    //调用注解对象中定义的抽象方法，获取返回值//注解中定义的就是抽象方法
    String className=an.className();   //拿到类名和方法名
    String methodName=an.methodName();

    //3加载该类进内存
    Class cls2=Class.forName(className);

    //4.创建对象
    Object obj=cls2.newInstance();
    //5.获取方法对象
    Method method =cls2.getDeclaredMethod(methodName);


    //使用方法
        method.invoke(obj);

    }


}
