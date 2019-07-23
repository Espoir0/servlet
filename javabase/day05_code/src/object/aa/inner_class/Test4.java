package object.aa.inner_class;

public class Test4 {
    public static void main(String[] args) {
        MyInterface in=new MyInterface() {
            @Override
            public void show() {
                System.out.println("我是匿名内部类");
            }
        };
        in.show();

        new MyInterface(){
            @Override
            public void show() {
                System.out.println("匿名内部类和匿名对象");
            }
        }.show();
    }
}
