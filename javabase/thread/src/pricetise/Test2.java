package pricetise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 1.定义一个数组存储Person对象
 * 2.使用Arrays中的sort对齐按年龄进行排序
 *      1.匿名内部类实现比较器
 *      2.lambda函数
 */
public class Test2 {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        Person[] p={
                new Person("ff",19),
                new Person("bb",17),
                new Person("cc",15),
                new Person("dd",22),
                new Person("aa",19)
        };
        Arrays.sort(p,new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                int result= o1.getAge()-o2.getAge();//升序排序

                if(result==0){
                    result=o1.getName().charAt(0)-o2.getName().charAt(0);//年龄相同比较名字的首字母
                }

                return result;
            }
        });

        System.out.println(Arrays.toString(p));

        //使用lambda函数
        Arrays.sort(p,(Person p1,Person p2)->{
            int result=p2.getAge()-p1.getAge();
            if(result==0){
                result=p2.getName().charAt(0)-p1.getName().charAt(0);
            }
            return result;
        });
        System.out.println(Arrays.toString(p));
    }



}

class Person {
    private String name;
    private int age;
    public String toString(){
        return ""+name+":"+age;
    }

    public Person(String name, int age){
        this.name=name;
        this.age=age;

    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}

