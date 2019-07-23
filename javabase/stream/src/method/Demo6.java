package method;

/**
 * 数组构造器引用
 *  1.定义一个 ArrayBuilder接口
 *          public abstract int[] build(int len);
 *  2.定义一个方法，
 *  private static int[] method(int len,ArrayBuilder builder)
 *
 *  3.使用lambda 和 数组构造器引用分别创建数组
 */
public class Demo6 {
    public static void main(String[] args) {
        method(4,len->new int[len]);
        method(4,int[]:: new);
    }

    private static int[] method(int len,ArrayBuilder builder) {
        return builder.build(len);

    }
}

@FunctionalInterface
interface ArrayBuilder{
    public abstract int[] build(int len);
}