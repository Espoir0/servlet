package cn.aa.day04.testpolymorphism;

public class Dog extends Animal{
    int age=10;

    @Override
    public void run() {
        System.out.println("dog running");
    }

    public void eat(){
        System.out.println("dog eat");
    }


    @Override
    public int getAge() {
        return age;
    }



}
