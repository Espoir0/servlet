package ClassObject;

import java.lang.reflect.Method;

public class Demo4 {
    public static void main(String[] args) throws Exception {
        Class personClass=Person.class;

        //获取方法
        Method m=personClass.getDeclaredMethod("eat");
        m.getName() ;//获取方法名字
        Person person = new Person();
        //使用方法
        m.invoke(person);

        Method m2=personClass.getDeclaredMethod("eat",String.class);
        m2.invoke(person,"fanfan");

        Method[] ms=personClass.getDeclaredMethods();  //获取所有方法，包括继承Object的


        //m2.setAccessible(true); 暴力反射


        String name=personClass.getName();//获取类名
    }

}
