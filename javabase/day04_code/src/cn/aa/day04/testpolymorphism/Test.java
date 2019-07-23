package cn.aa.day04.testpolymorphism;

public class Test {
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.run();


        System.out.println(animal.age);

        //直接通过属性名称访问成员变量没有重写，父类引用调用属性时，等号左边是谁，就调用谁的属性
        //间接通过成员方法访问成员变量，方法属于谁就优先用谁。
        System.out.println(animal.getAge());//如果子类有该方法就调用子类的方法
        System.out.println(animal.getAge2());//如果子类没有该方法就调用父类的方法

    }
}
