package serialiable;

import java.io.*;

/**
 * Serializable 称为标记接口，里面没有东西，只是为了标记
 * 序列化的对象必须实现该接口
 *
 * ObjectInputStream extends InputStream 对象的反序列化流，
 * 把文件中存储的对象以流的方式读取出来使用
 *       参数： FileInputStream
 */

public class Demo1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //test();
        test1();
    }

    private static void test1() throws IOException, ClassNotFoundException {
        //反序列化  类必须实现接口
        //必须有Class文件
        //InvalidClassException: serialiable.Person;
        //反序列化失败，修改了类文件的定义，必须重新序列化一次，然后反序列化，或者给类添加 序列化ID就不用修改了
        final ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\test\\persion.txt"));
        final Object o = ois.readObject();
        ois.close();

        System.out.println(o);


    }

    private static void test() throws IOException {
        final ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\test\\persion.txt"));
        oos.writeObject(new Person(18,"小美女"));
        oos.writeObject(new Person(19,"女"));
        oos.writeObject(new Person(20,"小美女"));
        oos.close();
    }
}

class Person implements Serializable {
    //private static final long serialVersionUID=1L;
    private int age;
    private String name;
    private static int id;
    private transient int num;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
