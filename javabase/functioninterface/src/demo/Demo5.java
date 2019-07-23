package demo;

/**
 * lambda 表达式在 Runnable接口中的使用
 *
 */
public class Demo5 {
    //定义一个开启线程的方法
    public static void main(String[] args) {

        //匿名内部类
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"线程启动");
            }
        });

        //lambda表达式
        startThread(()-> System.out.println(Thread.currentThread().getName()+"线程启动"));

        //直接使用lambda表达式开启线程
        new Thread(()-> System.out.println(Thread.currentThread().getName()+"线程启动》")).start();
    }


    private static void startThread(Runnable run) {
        new Thread(run).start();
    }
}
