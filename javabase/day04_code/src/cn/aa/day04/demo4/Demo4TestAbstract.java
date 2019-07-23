package cn.aa.day04.demo4;

import java.util.ArrayList;

/**
 * 写方法步骤：1.方法名   2.确定参数  3.确定返回值
 *
 * User: balance  name   show();
 * 群主： extends User
 *       ArrayList<Integer> send(int money,int count);
 *
 * 成员: extends User
 *      void receive(ArrayList<Integer> list);
 */
public class Demo4TestAbstract {
    public static void main(String[] args) {
        Lord lord = new Lord("群主",100);
        Member member = new Member("成员1",0);
        Member member2 = new Member("成员2",0);
        Member member3 = new Member("成员3",0);

        lord.show();
        member.show();
        member2.show();
        member3.show();

        ArrayList<Integer> list=lord.send(14,3);
        member.receive(list);
        member2.receive(list);
        member3.receive(list);

        lord.show();
        member.show();
        member2.show();
        member3.show();

    }
}
