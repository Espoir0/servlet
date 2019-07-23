package object.aa.API.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TestList {
    public static void main(String[] args) {


    //ArrayList线程不安全，效率高底层实现是数组，查询快，修改，插入，删除慢，
    //LinkList，线程不安全，效率高。底层实现是链表，查询快，修改，插入，删除快
    //Vector 线程安全，效率低
    //List内部是一个 object[] 数组，可存放所有对象
    List l2=new ArrayList();//常用写法，右边类左边接口
		l2.add("rrr");
		l2.add("ffd");

    List l=new ArrayList();
		l.add("aaa");
		l.add("bbb");
		l.add(1234);//包装类的自动装箱，转化为Integer对象
		l.add(new Date());
		l.add(new Person());
		System.out.println(l.size());
		l.add(l2);//将l2作为一个对象添加到l里面
		for(Object o:l) {
        System.out.println(o);
    }
		System.out.println("......."+l.size());

		l.remove("aaa");//此处的aaa和刚开始加到数组中的aaa是同一个对象的不同引用，指把对象移出去
		l.remove(new Date());//此处和老师讲的不一样，并没有将原来的Date移出去 Hashcode和equals方法
		System.out.println(l.size());
		for(Object o:l) {
        System.out.println(o);
    }

    //转化成object数组
    Object[]  obj=l.toArray();
		System.out.println(".......");
		System.out.println(Arrays.toString(obj));
//		l.clear();
//		System.out.println(l);
//

    //与index有关的操作
    //String s=(String)l.get(0);

		l.get(0);
		l.set(0, "djfksj");
		l.remove(3);
		l.isEmpty();


}

}

class Person{

}
