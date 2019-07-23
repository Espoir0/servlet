package runnable;


public class Demo1 {
    public static void main(String[] args) {

        RunnableImpl runnable = new RunnableImpl();

        Thread t1=new Thread(runnable);
        Thread t2=new Thread(runnable);
        Thread t3=new Thread(runnable);

        t1.start();
        t2.start();
        t3.start();


    }

}
