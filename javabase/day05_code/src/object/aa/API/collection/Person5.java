package object.aa.API.collection;

public class Person5 {
    int age;
    String name;

    public Person5() {
    }

    public Person5(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person5{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
