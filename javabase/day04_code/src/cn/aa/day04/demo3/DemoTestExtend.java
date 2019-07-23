package cn.aa.day04.demo3;

public class DemoTestExtend {
    public static void main(String[] args) {
        Dog dog = new Dog();
        //子类中与父类相同的属性时，覆盖父类属性。 子类中没有该属性时，会访问继承来的父类的属性
        System.out.println(dog.age+"  "+dog.name);
        dog.run();       //方法重写
        dog.sleep();     //animal sleep 调用继承而来的方法

        //多态，父类引用指向子类方法，创建的那个对象就调用谁的方法
        Animal a=new Dog();
        a.run();  //dog running
    }
}
