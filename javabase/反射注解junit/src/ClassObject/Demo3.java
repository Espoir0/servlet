package ClassObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo3 {
    public static void main(String[] args) throws Exception{
        Class<Person> personClass=Person.class;


        Constructor<Person> constructor1=personClass.getConstructor(String.class,int.class);
        Person p2=constructor1.newInstance("aa",19);  //利用构造器创建对象
        System.out.println(p2);//Person{name='aa', age=19, a='null', b='null', c='null', d='null'}




        //获取构造器
        Constructor<Person> constructor=personClass.getConstructor();
        Person p1=constructor.newInstance();  //利用构造器创建对象
        System.out.println(p1); //Person{name='null', age=0, a='null', b='null', c='null', d='null'}
        //空构造器创建对象的简单方法
        Person p3=personClass.newInstance();
        System.out.println(p3);
    }
}
