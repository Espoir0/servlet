package cn.aa.day04.demo1;
//求数组最大值

public class Demo5ArrayMax {
    public static void main(String[] args) {
        int[] arr={1,3,4,7,8,44,55,2,244};
        int max=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(max<arr[i]){
                max=arr[i];
            }
        }
        System.out.println(max);

    }
}
