package test;

import java.util.List;

public class TestMulitException {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        int[] arr={1,2,3};
        List<String> list = List.of("aa");

         //1.运行时异常可以不捕获
        System.out.println(arr[3]);
        System.out.println(list.get(1));

        //2.对每个异常分别进行捕获
        try {
            System.out.println(arr[3]);
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            System.out.println(list.get(1));
        } catch (Exception e) {
            System.out.println(e);
        }

        //3.一次捕获一次处理
        try {
            System.out.println(arr[3]);
            System.out.println(list.get(1));
        } catch (Exception e) {
            System.out.println(e);
        }

        //4.一次捕获多次处理
        //子类异常必须写在父类异常的上面，因为从上到下查找异常，由于多态，子类的异常捕获将执行不到
        try {
            System.out.println(arr[3]);
            System.out.println(list.get(1));
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }catch (Exception e) {
            System.out.println(e);
        }

    }
}
