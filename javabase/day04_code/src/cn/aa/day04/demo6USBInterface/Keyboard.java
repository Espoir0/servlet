package cn.aa.day04.demo6USBInterface;

public class Keyboard implements USB {
    @Override
    public void open() {
        System.out.println("start Keyboard");
    }

    @Override
    public void close() {
        System.out.println("close keyboard");
    }

    public void enter(){
        System.out.println("使用键盘输入：");
    }
}
