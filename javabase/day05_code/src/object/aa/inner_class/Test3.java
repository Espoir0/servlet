package object.aa.inner_class;

public class Test3 {
    public static void main(String[] args) {
        new Outter().show();
    }
}

class Outter{
    public void show(){
        class Inner{
            public void print(){
                System.out.println("我是局部内部类");
            }
        }
        new Inner().print();
    }

}
