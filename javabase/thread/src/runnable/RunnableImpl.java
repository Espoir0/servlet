package runnable;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableImpl implements Runnable {
    private  int ticket=2;
    //jdk1.5之后出现了Lock接口，
    Lock l=new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            l.lock();//在可能出现安全问题的代码块前。调用lock()方法
            if (ticket <= 0) {
               break;
            }
            try {
                Thread.sleep(50);
                System.out.println(Thread.currentThread().getName() + " ..." + ticket);
                ticket--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                //在可能出现问题的代码之后 调用 unlock();释放锁
                l.unlock();
            }


        }

    }

}
