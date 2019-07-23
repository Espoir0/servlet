package cn.aa.day04.demo1;

public class Demo3MethodOverload {
    public static void main(String[] args) {
        sum((short) 4,(short) 7);  //默认值为int需要强转为 short

    }
    public static short sum(short a,short b){
        System.out.println("short");
        return (short)( a+b);
    }
    public int sum(double a,int b){
        return (int)(a+b);
    }


    public int sum(int a,double b){
        return (int)(a+b);
    }


    public static int sum(int a, int b){
        return a+b;
    }

   /*返回值不同不构成方法的重载
   public void sum(int a,int b){
        return ;
    }*/
}
