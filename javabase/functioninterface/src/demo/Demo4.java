package demo;

/**
 * lambda表达式对日志案例优化
 *      lambda特性：延迟加载
 */
public class Demo4 {
    public static void main(String[] args) {
        String msg1="hello";
        String msg2="world";
        String msg3=" java";

        //匿名内部类实现
        showLog(1, new MessageBuilder() {
            @Override
            public String buildMessage() {
                return msg1+msg2+msg3;
            }
        });

        //lambda表达式实现
        showLog(1,()-> msg1+msg2+msg3);
    }

    private static void showLog(int level,MessageBuilder mb) {
        if (level==1){
            mb.buildMessage();
        }

    }
}

@FunctionalInterface
interface MessageBuilder{
    public abstract String buildMessage();
}
