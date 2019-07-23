package object.aa.inner_class;


public class Test2{
    public static void main(String[] args) {
        new Outer2().new Inner().show();
    }
}

class Outer2 {
    int name=10;
    public class Inner{
        int name;
        public void show(){
            System.out.println(name);//访问局部变量
            System.out.println(this.name);//访问成员变量
            System.out.println(Outer2.this.name);//访问外部类的成员变量
        }
    }
}
