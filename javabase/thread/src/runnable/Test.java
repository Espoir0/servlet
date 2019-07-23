package runnable;

/**
 * 创建一个线程：
 *      1.需要一个Thread类
 *      2.需要Runnable接口实现类定义thread执行的任务
 */

public class Test{
    public static void main(String[] args) {
        new Thread(new RunnableImpl2()).start();
        new Thread(new RunnableImpl2()).start();
        //匿名内部类创建Runnable接口实现类
        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("新线程开启"+Thread.currentThread().getName());
            }
        }).start();

        //lambda实现
        new Thread(()->{
            System.out.println("新线程开启"+Thread.currentThread().getName());
        }).start();
    }

}

class RunnableImpl2 implements Runnable {
    @Override
    public void run(){
        System.out.println("多线程开启"+Thread.currentThread().getName());
    }
}
