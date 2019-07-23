package cn.aa.day04.demo5;

public interface MyInterfacePrivate {
    private void method(){
        System.out.println("aaa");
        System.out.println("bbb");
        System.out.println("ccc");
    }
    public default void method1(){
        method();
        System.out.println("default method1");
    }

    public default void method2(){
        method();
        System.out.println("default method1");
    }
}
