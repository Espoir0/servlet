package object.aa.inner_class.prictise;

import object.aa.inner_class.red.OpenMode;

/**
 * 1.红包发出去之后大家都有红包，最后一个红包给群主自己
 * 2.设置程序标题
 * 3.设置群主名称
 * 4，设置分发策略：平均还是随机
 *
 * 红包分发的策略：
 * 1.普通红包：（平均）totalAmount/count     ,余数放在最后一个红包当中
 * 2.手气红包：（随机）最少一分钱，最多不超过平均数的二倍，越发越少
 */
public class Bootstarp {
    public static void main(String[] args) {
        MyRed myred = new MyRed("myred");
        myred.setOwnerName("aa");

        OpenMode normal=new NormalMode();
        OpenMode random=new RandomMode();
        myred.setOpenWay(random);
    }
}
