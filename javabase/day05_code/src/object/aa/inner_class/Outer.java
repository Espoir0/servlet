package object.aa.inner_class;

public class Outer {
    private int age;
    public void show(){
        System.out.println("在外部类中创建内部类对象，然后调用内部类方法");
        new Inner().show();
    }
    class Inner{
        int in;
        public void show(){
            System.out.println("我是内部类");
        }
    }



}
