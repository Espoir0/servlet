package demo;

public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("舒淇","年龄20");
        Person p2 = new Person("柳岩","年龄21");
        swap(p1,p2);
        System.out.println(p1);
        System.out.println(p2);

    }
    public static void swap(Person p1,Person p2){
        Person temp=p1;
        p1=p2;
        p2=temp;
        System.out.println(p1);
        System.out.println(p2);
    }

}

class Person{
    String name;
    String age;


    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name='" + name +"age="+age ;
    }
}
