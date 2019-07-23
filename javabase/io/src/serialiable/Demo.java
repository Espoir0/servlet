package serialiable;

import java.io.*;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        test1();
        test();
    }

    private static void test1() throws IOException {
         ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\test\\persons.txt"));
         ArrayList<Person> list = new ArrayList<>();
         list.add(new Person(12,"aa"));
         list.add(new Person(13,"bb"));
         list.add(new Person(14,"cc"));
         oos.writeObject(list);
         oos.close();

    }

    private static void test() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\test\\persons.txt"));
        Object o = ois.readObject();
        ArrayList<Person> list = (ArrayList<Person>) o;
        for (Person person : list) {
            System.out.println(person);
        }
        ois.close();

    }
}

