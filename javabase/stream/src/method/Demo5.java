package method;

/**
 * 1.定义一个BuildPerson 接口
 *       有一个抽象方法 buildPerson();
 * 2.测试类中定义一个method(String name,BuilderPerson b)方法，创建人
 * main方法中调用的时候 使用lambda和构造器引用
 * 类的构造器引用
 */
public class Demo5 {
    public static void main(String[] args) {
        System.out.println(method("aa",s->new Person(s)).getName());

        //构造器引用 new
        System.out.println(method("aa",Person::new).getName());
    }

    private static Person method(String name,BuilderPerson build) {
        return build.buildPerson(name);
    }

}

@FunctionalInterface
interface BuilderPerson{
    public abstract Person buildPerson(String name);
}



class Person{
    String name;
    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
