package cn.aa.day04.demo4;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    static int count;
    public Member(){
        count++;
    }
    public Member(String name,int balance){
        super(name,balance);
        count++;
    }

    public void receive(ArrayList<Integer> list){
        int balance=super.getBalance();
        int index=new Random().nextInt(list.size());
        int money=list.remove(index);
        super.setBalance(balance+money);
    }
}
