package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * JDK1.5以后提供的
 *      java.util.concurrent.Executors:线程池的工厂类。用来生产线程池
 *      Executors 类中的静态方法
 *
 *      public static ExecutorService newFixedThreadPool(int nThreads)
 *      返回值是 ExecutorService接口的实现类对象，用ExecutorService接收，面向接口编程
 *
 *      java.util.concurrent.ExecutorService线程池接口
 *      从线程池中获取线程，调用start()方法，执行线程任务
 *          submit(Runnable task) 提交一个Runnable任务用于执行
 *
 *          关闭或者销毁线程池的方法
 *          shutdown()
 *
 *  使用方法：
 *       1.创建线程池  newFixedThreadPool(1);
 *       2.创建Runnable的实现类  RunnableImpl
 *       3.submit(new RunnableImpl())
 *       4.不用的时候进行shutdown()
 *
 */

public class Demo {
    public static void main(String[] args) {
        ExecutorService es=Executors.newFixedThreadPool(1);
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());
        es.submit(new RunnableImpl());


    }
}

class RunnableImpl implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"vvvv");
    }
}
