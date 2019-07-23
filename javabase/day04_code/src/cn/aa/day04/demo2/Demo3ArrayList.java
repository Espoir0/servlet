package cn.aa.day04.demo2;

import java.util.ArrayList;
import java.util.Random;

/**
 * 定义一个大集合存储20个随机数字，选出偶数放入小集合中
 */

public class Demo3ArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();


        Random r = new Random();
        for (int num, i = 0; i < 20; i++) {
            num=r.nextInt(100);
            l.add(num);
        }

        choiceEven(l,l2);
        System.out.println(l);
        System.out.println(l2);
    }

    private static void choiceEven(ArrayList<Integer> list,ArrayList<Integer> list2) {
        for (int i = 0; i < 20; i++) {
            if(list.get(i)%2==0){
                list2.add(list.get(i));
            }
        }
    }

}
