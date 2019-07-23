package runnable;

/**
 * 等待唤醒案例：线程之间的通信
 *
 *  1.创建一个消费者线程：告知需要的数量。调用wait()方法，放弃cpu的执行，进入到WAITING状态
 *
 *  2.创建一个生产者线程，花费5秒时间做包子，做好包子之后，唤醒顾客
 *
 *    消费者和生产者必须用同步代码块包起来，保证等待和唤醒只能有一个在执行
 *    同步使用的锁对象必须唯一
 *    只有锁对象才能调用 wait()和notify()方法
 *
 *  Object类中的方法
 *      wait(),当前线程进入等待状态，直到在其他线程调用 此对象的notify()方法
 *      相当与一个监视器，调用wait()方法后，线程进入等待状态，直到发现其他线程调用notify()方法。唤醒该线程
 *      notify();唤醒此对象监视器上的单个进程，继续执行wait()后面的代码
 */
public class Demo4 {
    public static void main(String[] args) {
        Object obj=new Object();//创建唯一对象.在线程当中该对象调用wait()方法，是所在线程进入wait状态
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized(obj) {
                        System.out.println("我需要10个");
                        try {
                            obj.wait();//进入等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("吃完了包子");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000);//5s之后
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized(obj) {

                        System.out.println("包子做好了");
                        obj.notify();//唤醒顾客，让顾客吃包子
                    }
                }

            }
        }).start();
    }
}
