package object.aa.API.collection;

public class Person1 implements Comparable<Person1> {
    private int age;
    private String name;

    public Person1(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person1 o) {
        //return 0;
        return this.age-o.age;
    }
}
