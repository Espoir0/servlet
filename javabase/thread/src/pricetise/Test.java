package pricetise;
/**
 * 资源类：包子
 *      皮，馅
 *      有true   没有false
 * 生产者类：
 *      1.线程类
 *      2.(包子铺) ：生产包子(资源) ，
 *      3.判断是否有包子，没有在话生产包子，生产完毕。包子状态变为true,
 *      4.进入wait() 状态，唤醒消费者
 * 消费者类：
 *      1.线程类
 *      2.() 判断是否有包子，如果有包子则吃包子，吃完包子，包子状态变为false
 *       唤醒生产者。制作包子
 *      3.进入wait（）状态，并唤醒生产者
 * 测试类：main方法
 *
 */
public class Test {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Make make=new Make(resource);
        make.setName("包子铺");
        Eat eat=new Eat(resource);
        eat.setName("顾客一");
        make.start();
        eat.start();
    }
}

class Make extends Thread{
    private Resource resource;

    public Make(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        int count=0;
        while (true) {

            //对resource进行锁定
            synchronized (resource) {
                //判断是否存在包子
                if (!resource.flag) {
                    if(count%2==0) {

                        resource.pi = "薄皮";
                        resource.xian = "牛肉";
                        System.out.println("正在制作-->" + resource.xian + resource.pi + "包子");
                    }else {
                        resource.pi = "冰皮";
                        resource.xian = "三鲜";
                        System.out.println("正在制作-->" + resource.xian + resource.pi + "包子");
                    }
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(resource.xian+resource.pi+"包子制作完毕");
                    resource.flag=true;
                    count++;
                    resource.notify();

                }else {
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}

class Eat extends Thread{
    private Resource resource;

    public Eat(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        int count=0;
        while (true) {

            //对resource进行锁定
            synchronized (resource) {
                System.out.println("我要吃五个包子");
                //判断是否存在包子
                if (resource.flag) {
                    System.out.println(Thread.currentThread().getName()+"吃了"+resource.pi+resource.xian+"包子");
                    System.out.println("********************************");
                    resource.flag=false;
                    resource.notify();
                }else {
                    try {
                        resource.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}

class Resource{
    boolean flag =false;
    String pi;
    String xian;
}


