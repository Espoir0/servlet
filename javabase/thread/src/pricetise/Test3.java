package pricetise;

/**
 * 定义计算器接口 Calculator ,包含抽象方法，calc()对多个数字求和
 * 测试类中调用invokeColc()方法传入数值，并激活计算器，进行计算
 */
public class Test3 {
    public static void main(String[] args) {
        invokeColc(1, 3, new Calculator() {
            @Override
            public int calc(int a, int b) {
                //计算器值进行计算无其他操作
                return a+b;
            }
        });

        invokeColc(2,4,(int a,int b)->{
            return a+b;
        });

        invokeColc(2,4,(a, b)->a+b);


    }

    private static void invokeColc(int a,int b,Calculator c) {
        int result=a+b;
        System.out.println(result);
    }
}

interface Calculator{
    public abstract int  calc(int a,int b);
}


