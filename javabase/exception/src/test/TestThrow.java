package test;

import java.util.Objects;

/**
 *  throw关键字：可以使用throw关键字在指定的方法中抛出指定的异常
 *
 *  throw new xxxException("产生异常的原因")；
 *      1.throw关键字必须写在方法的内部
 *      2.抛出的必须是Exception或者Exception的子类
 *      3,。throw 抛出异常后，就必须对异常处理‘
 *          如果是runtimeException可以不处理，交给JVM去处理
 *          如果是编译时期异常（写代码时候报错，）必须对异常处理，try-catch 或者throws
 *
 *
 */
public class TestThrow {
    public static void main(String[] args) {
        int[] arr=null;
//        int[] arr=new int[3];
        test1(arr,3);
    }

    private static void test1(int[] arr,int index) {
/*        if(null==arr){
            throw new NullPointerException("空指针异常");
        }*/
/*
        //Objects类中提供了静态方法，可以简化判断空指针异常的代码；
        public static <T> T requireNonNull(T obj, String message) {
            if (obj == null)
                throw new NullPointerException(message);
            return obj;
        }*/
        Objects.requireNonNull(arr,"空指针异常");

        if(index>=arr.length ||index<0){
            throw new ArrayIndexOutOfBoundsException("数组越界异常");
        }
        System.out.println(arr[index]);

    }
}
