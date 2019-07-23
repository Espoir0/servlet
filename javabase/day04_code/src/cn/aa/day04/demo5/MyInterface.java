package cn.aa.day04.demo5;

public interface MyInterface {
    public abstract void method();
    public default void method1(){
        System.out.println("default method");
    }
}
