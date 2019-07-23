package object.aa.inner_class.prictise;

import object.aa.inner_class.red.OpenMode;

import java.util.ArrayList;

public class NormalMode implements OpenMode {
    @Override
    public ArrayList<Integer> divide(int totalMoney, int totalCount) {
        ArrayList<Integer> list = new ArrayList<>();

        int money=totalMoney/totalCount;
        int mod=totalMoney%totalCount;

        for (int i = 0; i < totalCount-1; i++) {
            list.add(money);
        }
        list.add(money+mod);

        return list;
    }
}
