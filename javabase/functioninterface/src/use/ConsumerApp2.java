package use;

import java.util.function.Consumer;

/**
 *
 * 将字符数组中的的信息 按照格式输出：   姓名：xx,性别：xx
 * 刚开始把整个数组一起处理，Consumer的泛型是一个数组，两个输出器是分离的，所以无法得到想要的效果
 *           姓名：aa        第二版输出：
 *           姓名：bb        姓名：aa,性别：18
 *           姓名：cc        姓名：bb,性别：19
 *           性别：18        姓名：cc,性别：20
 *           性别：19
 *           性别：20
 *
 *
 * 改进：for循环将数组拆分，两个lambda处理一个字符串的两部分，就可以实现拼接
 *
 */
public class ConsumerApp2 {
    public static void main(String[] args) {
        String[] arr=new String[]{"aa,18","bb,19","cc,20"};

        //第二版
        for (String temp:arr){

            method2(temp,(s)->{
                // 逗号分隔去第一个元素    split(",")[0]
                System.out.print("姓名："+temp.substring(0,2)+",");
            },(s)->{
                System.out.println("性别："+temp.substring(3));
            });

        }
        /**
         * 第一版
         */
        method(arr,(t)->{
            for (int i = 0; i < t.length; i++) {
                String s=t[i].substring(0,2);
                System.out.println("姓名："+s);
            }
        },(t)->{
            for (int i = 0; i < t.length; i++) {
                String s=t[i].substring(3);
                System.out.println("性别："+s);
            }

        });
    }

    //第二版
    private static void method2(String s,Consumer<String> con1,Consumer<String> con2) {
        con1.andThen(con2).accept(s);
    }

    private static void method(String[] arr, Consumer<String[]> con1,Consumer<String[]> con2) {
        con1.andThen(con2).accept(arr);

    }


}
