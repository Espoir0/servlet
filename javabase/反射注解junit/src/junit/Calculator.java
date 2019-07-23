package junit;

public class Calculator {
    /**
     * @since  1.5
     * @param arr 多个整数
     * @return 多个整数之和
     */
    public int add(int... arr){
        int sum =0;
        for (int i = 0; i < arr.length; i++) {
            sum+= arr[i];
        }
        return sum;
    }

    public int sub(int... arr){
        int result=arr[0];
        for (int i = 1; i < arr.length; i++) {
            result =result-arr[i];
        }
        return result;


    }
}
