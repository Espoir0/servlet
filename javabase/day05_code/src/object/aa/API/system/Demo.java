package object.aa.API.system;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        demo();
        demo2();
    }


    private static void demo2() {
        int[] arr={1,2,3,4,5,6};
        int[] arr2=new int[5];
        System.arraycopy(arr,0,arr2,1,3);
        System.out.println(Arrays.toString(arr2));
    }

    private static void demo() {
        System.currentTimeMillis();
    }
}
