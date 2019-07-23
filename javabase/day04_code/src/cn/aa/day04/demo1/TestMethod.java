package cn.aa.day04.demo1;

public class TestMethod {
    public static void main(String[] args) {
        System.out.println(isSame(4,8));
    }

    private static boolean isSame(int a,int b) {
        /*boolean same;
        if (a == b) {
            same= true;
        } else {
            same=false;
        }
        return same;*/

        /*boolean same=a==b ? true :false;*/

        return a==b;
    }
}


