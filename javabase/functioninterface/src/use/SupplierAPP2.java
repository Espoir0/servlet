package use;

import java.util.function.Supplier;

/**
 * 使用Supplier获取数组中的最大值
 * 1.先写 getMax(); 参数是Supplier
 * 2.返回 sup.get()
 * 3.lambda中重写get()方法，执行的时候就是多态，lambda感觉就是一个匿名实现类
 */
public class SupplierAPP2 {
    public static void main(String[] args) {
        int[] arr={12,45,64,345,52,1,454,43,5,415};
        getMax(()->{
            int max=arr[0];
            for (int i = 1; i < arr.length; i++) {
                if(arr[i]>max) max=arr[i];
            }

            return max;
        });
    }

    private static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }
}
