/**
 * 选择排序： 对于0---(N-1)的i 都会进行 N-i-1次交换
 *
 *
 */

public class Example {
    //选择排序
    public static void sort(Comparable[] arr){
        for(int i=0;i<arr.length;i++){
            int min=i;

            for (int j= i+1; j < arr.length; j++)
                if (less(arr[j],arr[min])) min=j;
            exch(arr,i,min);

        }

    }

    //比较谁小
    private static boolean less(Comparable c1,Comparable c2){
        return c1.compareTo(c2) <0;
    }

    //在数组中交换两个元素
    private static void exch(Comparable[] arr,int i,int j){
        Comparable temp=arr[i]; arr[i]=arr[j] ; arr[j]=temp;
    }

    //输出数组
    private static void show(Comparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


    private static boolean isSorted(Comparable[] arr)
    {
        for (int i = 1; i < arr.length; i++)
            if(less(arr[i],arr[i-1])) return false;
        return true;
    }

    public static void main(String[] args) {
        String[] strings ={"v","c","y","x","b","m","z","n"};
        System.out.println(isSorted(strings));
        sort(strings);
        System.out.println(isSorted(strings));
        show(strings);

    }

}
