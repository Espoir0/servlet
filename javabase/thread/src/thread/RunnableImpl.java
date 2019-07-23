package thread;

/**
 * 创建线程的第二种方式，
 *      1.实现类实现 Runnable 接口，重写run()方法
 *      2.创建实现类对象
 *      3.创建Thread 对象，吧实现类对象作为参数，
 *      4.Thread对象调用start()方法
 */
public class RunnableImpl implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
