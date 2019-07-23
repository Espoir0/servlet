package cn.aa.day04.demo6USBInterface;

public class Computer {
    public void open(){
        System.out.println("start computer");
    }

    public void close(){
        System.out.println("close computer");
    }
    public void useDevice(USB usb){
        usb.open();
        if(usb instanceof Mouse){
            ((Mouse) usb).click();
        }
        if(usb instanceof Keyboard){
            ((Keyboard)usb).enter();
        }
        usb.close();


    }
    public void closeDevice(USB usb){
        usb.close();
    }
}
