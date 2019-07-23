package cn.aa.day04.demo4;

import java.util.ArrayList;

public class Lord extends User{
    public Lord() {
    }
    public Lord(String name,int balance){
        super(name,balance);

    }

    //发红包
    public ArrayList<Integer> send(int money,int count){


        //将红包分为count份，存入list,余数直接放在最后
        ArrayList<Integer> list = new ArrayList<>();

        //查看当前余额 写super只是表示该方法是继承来的，不写也行，
        int balance=super.getBalance();
        if(money>balance){
            System.out.println("余额不足");
            return list;
        }


        int avg=(int) money/count;
        int mod=money%count;
        for (int i = 0; i < count-1; i++) {
            list.add(avg);
        }
        list.add(avg+mod);


        super.setBalance(balance-money);//重新设置balance
        return list;
    }

}
