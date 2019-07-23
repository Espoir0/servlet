package method;

/**
 * 通过类名引用静态方法
 *
 * //定义一个能计算的接口 Calcable
 */
public class Demo3 {
    public static int abs(int num,Calcable c){
        return c.calc(num);
    }
    public static void main(String[] args){
        //lambda
        System.out.println(abs(-10,num-> Math.abs(num)));

        //方法引用
        System.out.println(abs(-10,Math::abs));
    }


}

@FunctionalInterface
interface Calcable{
    public abstract int calc(int num);
}

