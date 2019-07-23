package cn.aa.day04.demo6USBInterface;

public class Mouse implements USB{
    @Override
    public void open() {
        System.out.println("启动鼠标");
    }

    @Override
    public void close() {
        System.out.println("关闭鼠标");

    }
    public void click(){
        System.out.println("点击鼠标");
    }
}
