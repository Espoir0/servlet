package object.aa.inner_class.prictise;

import object.aa.inner_class.red.OpenMode;
import java.util.ArrayList;
import java.util.Random;

/**
 * 随机发，最少0.01  最多不超过剩下金额的二倍
 */

public class RandomMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {
        ArrayList<Integer> list=new ArrayList<>();
        int leftMoney=totalMoney;
        int leftCount =totalCount;
        int money=0;
        Random random = new Random();

        for (int i=0;i<totalCount-1;i++){
            money=random.nextInt(2*leftMoney/leftCount)+1;
            list.add(money);
            leftCount--;
            leftMoney -= money;
        }
        list.add(leftMoney);
        return list;
    }
}
