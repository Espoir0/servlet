package demo;

public class Demo3 {
    public static void main(String[] args) {
        String msg1="hello";
        String msg2="world";
        String msg3=" java";

        //如果level 不符合，不会输出，但是也拼接了字符串，造成性能浪费
        showLog(1,msg1+msg2+msg3);
    }

    //根据日志级别，输出message
    private static void showLog(int level,String message) {
        if(level==1){
            System.out.println(message);
        }

    }
}
