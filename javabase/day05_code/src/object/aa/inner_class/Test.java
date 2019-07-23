package object.aa.inner_class;

public class Test {
    public static void main(String[] args) {
        new Outer().new Inner().show();//匿名对象的方式
        Outer.Inner in =new Outer().new Inner();
        in.show();
    }
}
