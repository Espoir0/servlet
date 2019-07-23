package cn.aa.day04.demo2;

import java.util.ArrayList;

/**
 * //<Element>泛型，表示ArrayList中存储的类型，泛型中只能是引用类型，存储的地址值，基本类型没有地址值
 *         //jdk1.7+ 开始右侧的<>内可以不写内容
 *         //ArrayList中重写了toString();
 *         //常用方法：add() get() remove() size()
 *         jdk1.5+ 基本类型和包装类型进行  开始自动装箱 自动拆箱
 *
 */


public class Demo1ArrayList {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("橘子");
        list.add("苹果");

        //基本类型到引用类型的自动装箱
        ArrayList<Integer> list2=new ArrayList<>();
        list2.add(3);
        list2.add(4);
        int num=list2.get(1);//自动拆箱，不用强制类型转换

        //对于引用类型的对象可以使用反射判断，基本类型不可以直接判断，需要自己写方法判断
        System.out.println(list2.get(1).getClass().getName());

        //不加泛型时任何类型都可以添加
        ArrayList list3=new ArrayList();
        list3.add("dd");
        list3.add(3);
    }
}
