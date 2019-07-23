package pricetise;

/**
 * 1. 定义一个 Cook接口 ，里面之有一个抽象方法make()
 * 2. 激活cook做饭
 *
 */
public class TestLambda {
    public static void main(String[] args) {

        //1.匿名内部类的方式
        invokeCook(new Cook() {
            @Override
            public void make() {
                System.out.println("饭做好了");
            }
        });


        //2.采用lanbda
        invokeCook(()->{
            System.out.println("饭做好了");
        });

    }

    private static void invokeCook(Cook cook) {
        cook.make();
    }

}

interface Cook{
    public abstract void make();
}