package thread;

public class TestsetName {
    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        //使用setName()方法
        mythread.setName("aa");
        mythread.start();

        //给自定义的线程，添加构造器，构造器里面调用父类构造器，创建线程的时候，传入线程的名字；
        new Mythread("bb").start();
    }
}
