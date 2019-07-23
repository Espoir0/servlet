package cn.aa.day04.demo2;

import java.util.ArrayList;

/**
 * 定义一个方法按指定格式输出ArrayLiat所有元素
 */
public class Demo2ArrayList {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        printArrayList(list);

    }

    public static void printArrayList(ArrayList<String> list){
        System.out.print("{");
        for (int i = 0; i < list.size(); i++) {
            if(i==list.size()-1){
                System.out.println(list.get(i)+"}");
            }else {
                System.out.print(list.get(i)+"^");
            }
        }
    }
}
