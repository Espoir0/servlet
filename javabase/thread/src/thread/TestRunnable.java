package thread;

/**
 * 匿名内部类实现Runnable接口
 */
public class TestRunnable {
    public static void main(String[] args) {

        //匿名内部类方式使用Thread
        new Thread(){
            @Override
            public void run() {
                System.out.println("run ");
            }
        }.start();

        //匿名内部类方式使用 Runnable
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+i);
                }
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }

}
