package thread;

public class TestThread {
    public static void main(String[] args) {
        new Mythread().start();
        new Mythread().start();
        new Mythread().start();
        new Mythread().start();
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        System.out.println(Thread.currentThread()+"  "+Thread.currentThread().getName());
    }
}
