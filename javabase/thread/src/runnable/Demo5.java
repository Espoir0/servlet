package runnable;

/**
 * wait(time)，如果在毫秒值之前没有被唤醒，等到毫秒值结束之后，自动唤醒，线程进入到 Runnable/blocked状态
 * sleep(time) ,毫秒值结束之后，程序进入到 Runnable/blocked状态
 *
 * nitifyAll() 唤醒所有waitting中的线程
 *
 * 1.创建老板线程
 * 2.创建顾客一线程  进入waitting状态
 * 3.创建顾客二线程  进入waitting状态
 * 4.顾客一和顾客二被同一把锁锁住
 *     老板，顾客一，顾客二  对同一份资源同步（锁定同一份资源）
 *
 */
public class Demo5 {
    public static void main(String[] args) {
        Object o = new Object();
        Runnable run=new Runnable() {
            @Override
            public void run() {

                while (true){synchronized(o) {
                    System.out.println(Thread.currentThread().getName() + "：给我五个");
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"开吃");
                }
                }

            }
        };

        Thread t1=new Thread(run);
        t1.setName("顾客一");
        Thread t2=new Thread(run);
        t2.setName("顾客二");

        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    synchronized (o) {
                        //o.notify();//只会唤醒一个
                        o.notifyAll();
                        System.out.println("做好了");
                    }
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
