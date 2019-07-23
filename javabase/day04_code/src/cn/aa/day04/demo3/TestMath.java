package cn.aa.day04.demo3;

/**
 *  -10.8 到5.9之间 绝对值大于6或者小于2.1的整数个数
 */

public class TestMath {
    public static void main(String[] args) {
        int count=0;
        for(int i=-10;i<6;i++){
            if(Math.abs(i)>6 || Math.abs(i)<2.1){
                count++;
            }

        }
        System.out.println(count);

    }
}
