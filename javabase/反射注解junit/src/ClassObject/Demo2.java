package ClassObject;

import java.lang.reflect.Field;

public class Demo2 {
    public static void main(String[] args) throws Exception {
        Class personClass=Person.class;

        Field[] fields=personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);  //public java.lang.String ClassObject.Person.a
        }

        Person p = new Person();
        Field aa=personClass.getField("a");//获取属性a，构成的Field对象
        aa.set(p,"舒淇");       //设置 对象 p的a属性
        System.out.println(aa.get(p));   //获对象p 的a属性的值 舒淇
        System.out.println(aa.getName());   //获取属性的名字  a

        Field[] fields2=personClass.getDeclaredFields();//忽略修饰符，全部获取到
        for (Field field : fields2) {
            System.out.println(field);
        }

        Field dd=personClass.getDeclaredField("d");
        dd.setAccessible(true);//设置安全检查  暴力反射
        System.out.println(dd.get(p));   //null

    }
}
