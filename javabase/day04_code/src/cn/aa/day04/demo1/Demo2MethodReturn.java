package cn.aa.day04.demo1;

/**
 * 想在一个方法里面返回多个值时，可以将要返回的值放在数组里面
 * 然后返回数组
 */
public class Demo2MethodReturn {
    public static void main(String[] args) {
        int[] a=sumAndProduct(10,5);
        System.out.println("sum"+a[0]);
        System.out.println("product"+a[1]);


    }

    public static int[] sumAndProduct(int a,int b){
        int sum=a+b;
        int product=a*b;
        int[] arr={sum,product};
        return arr;
    }
}
