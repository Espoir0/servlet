package demo;

/**
 * 函数式接口的使用
 */
public class Demo2 {
    public static void main(String[] args) {
        //使用接口的实现类作为参数
        test(new FunctionInterfaceImpl());

        //使用匿名内部类
        test(new FunctionInterface(){
            @Override
            public void method(){
                System.out.println("我是匿名内部类");
            }
        });

        //lambda表达式
        test(()->{
            System.out.println("我是lambda表达式");
        });

        test(()-> System.out.println("我是简化的lambda表达式"));
    }

    //定义一个方法，参数是接口，使用多态。
    private static void test(FunctionInterface funcInter) {
        funcInter.method();
    }
}

class FunctionInterfaceImpl implements FunctionInterface{
    @Override
    public void method() {
        System.out.println("我是实现类");
    }
}
