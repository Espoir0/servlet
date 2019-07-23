package thread;

/**
 * 创建多线程的方法一：
 *      1.子类继承Thread类，并重写 run()方法，在run()方法中写要运行的代码
 *      2.创建子类对象，调用start()方法，开启新的线程，执行run()方法
 *          start()方法使该线程开始执行，JVM调用run（）方法
 *          结果是两个线程并发的执行：main()线程和创建的另一个线程（创建的新线程，执行其run()方法）
 *
 *          java虚拟机属于抢占式调度，线程的优先级高的优先执行，优先级相同的，随机执行
 *          执行过程中交替执行
 *
 */

public class Mythread extends Thread {
    public Mythread() {
    }
    public Mythread(String name){
        super(name);
    }

    @Override
    public void run() {

        System.out.println(getName());

    }
}
