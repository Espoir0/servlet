package method;

public class Human {
    public void sayHello(){
        System.out.println("hello human");
    }
}

class Man extends Human{
    @Override
    public void sayHello(){
        System.out.println("hello man");
    }

    public void method(Greetable g){
        g.greet();
    }


    public void show(){
        //通过super引用父类的方法
        method(()->new Human().sayHello());
        method(()->super.sayHello());
        method(super::sayHello);

        //通过this 引用自身的方法
        method(()->new Man().sayHello());
        method(()->this.sayHello());
        method(this::sayHello);
    }

    public static void main(String[] args) {
        new Man().show();

    }
}

@FunctionalInterface
interface Greetable{
    public abstract void greet();
}