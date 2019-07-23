package ClassObject;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class cls1=Class.forName("ClassObject.Person");

        Class cls2=Person.class;

        Person p=new Person("aa",12);
        Class cls3=p.getClass();

        System.out.println(cls1==cls2);
        System.out.println(cls1==cls3);
    }
}
