package cn.aa.day04.demo1;

/**
 * 数组元素反转
 * 思路：对位元素交换
 * 1.i<arr.length/2 时循环进行数组交换
 * 2.定义两个辅助下标 min<max是进行数组交换
 */
public class Demo6ArrayReverse {
    public static void main(String[] args) {
        int[] arr={5,77,3,88,5,6,7,9};
        printArray(arr);
        reverse1(arr);
        printArray(arr);
        reverse2(arr);
        printArray(arr);



    }
    private static void printArray(int[] arr){
        for(int temp:arr){
            System.out.print(temp+" ");
        }
        System.out.println();
    }

    private static void reverse2(int[] arr) {
        for(int min=0,max=arr.length-1;min<max;min++,max--){
            int temp=arr[min];
            arr[min]=arr[max];
            arr[max]=temp;
        }
    }

    private static void reverse1(int[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            int temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }
    }


}
