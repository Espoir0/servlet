package test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 输入一个用户名，检测数据库中是否存在该用户名
 */

public class TestMyException {
    public static void main(String[] args) {
        String username=new Scanner(System.in).next();

        checkName(username);

    }

    private static void checkName(String username) {
        List<String> usernames=List.of("aa","bb","cc");

        Iterator<String> iter=usernames.iterator();
        while (iter.hasNext()){
            if(iter.next().equals(username)){
                try {
                    throw new MyException();
                } catch (MyException e) {
                    System.out.println("该用户名已存在");
                    return;
                }
            }
        }

        usernames.add(username);
        System.out.println("注册成功");
    }
}
