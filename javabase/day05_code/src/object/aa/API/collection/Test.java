package object.aa.API.collection;

/**
 * 可变参数：
 *  1.已知数据类型，但不知道参数个数的时候用可变参数
 *  2.jdk1.5后新加方法；
 *  3.一个方法只能有一个可变参数
 *  4.方法的参数有多个时，可变参数必须写在最后面：
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(sum(1,2,4,5,3));
    }

    private static int sum(int a,double b,int ...arr) {
        int sum=0;
        sum+= a+ b;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum;
    }
}
