package demo;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 当需要获取Compaator接口类型的比较器时可以用，
 * lambda表达式作为返回值
 */
public class Demo6 {
    public static void main(String[] args) {
        String[] arr={"aaa","ff","fdfjal","dafja"};

        //对数组排序可以只写用 lambda 一行搞定：
        Arrays.sort(arr,(o1,o2)->o1.length()-o2.length());

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr,getComparator());
        Arrays.sort(arr,getComparator2());
        System.out.println(Arrays.toString(arr));

    }

    private static Comparator<String> getComparator2() {
        //lambda表达式实现；按照长度降序
        /*return (String o1,String o2) -> {
            return o2.length()-o1.length();
        };*/

        return (o1,o2)-> o2.length()-o1.length();
    }

    //定义方法 返回一个比较器，按照字符串长度升序排列
    private static Comparator<String> getComparator() {
        //匿名内部类实现
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        };
    }
}