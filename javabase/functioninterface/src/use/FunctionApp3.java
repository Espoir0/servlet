package use;

/**
 * 取出年龄  + 100 ，
 */
public class FunctionApp3 {
    public static void main(String[] args) {
        String s="aa,19";
        System.out.println(method(s));
    }

    private static int  method(String s) {
        return Integer.parseInt(s.split(",")[1])+10;
    }
}
