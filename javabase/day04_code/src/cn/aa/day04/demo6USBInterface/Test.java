package cn.aa.day04.demo6USBInterface;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.open();

//        USB usbMouse=new Mouse();
//        computer.useDevice(usbMouse);

        //自动向上转型，自动装箱
        computer.useDevice(new Mouse());
        computer.useDevice(new Keyboard());


    }
}
