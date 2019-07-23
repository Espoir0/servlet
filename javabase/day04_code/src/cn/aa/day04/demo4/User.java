package cn.aa.day04.demo4;

public abstract class User {
    private String name;
    private int balance;

    public User() {
    }

    public User(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public  void show(){
        System.out.println("我是"+name+" "+"我有"+balance+"钱");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
