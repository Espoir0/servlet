public class Demo3 {
    public static void main(String[] args) {
        System.out.println(sum(5));
    }

    // f(n) + f(n-1) +f(n-2) +...+ f(1);
    private static int sum(int num) {
        if(num==1) return 1;
        return num*sum(num-1);

    }
}
