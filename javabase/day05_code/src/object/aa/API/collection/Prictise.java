package object.aa.API.collection;

import javafx.print.Collation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1.定义54张牌
 *     两个集合/数组
 * 2.将54张牌放入一个集合
 * 3.将54张牌打乱：  Collections.shuffle()
 * 4.准备三个数组或者集合 分别存储三个玩家的牌
 * 5.叫地主
 *
 *
 */
public class Prictise {
    public static void main(String[] args) {

        List<String> list=shuffleCard();//洗牌
        deal(list);//发牌

    }

    private static void deal(List<String> list) {
        ArrayList<String> list1 = new ArrayList<>();//玩家一
        ArrayList<String> list2 = new ArrayList<>();//玩家二
        ArrayList<String> list3 = new ArrayList<>();//玩家三
        ArrayList<String> list4 = new ArrayList<>();//地主牌

        for (int i = 0; i < list.size(); i++) {
            //地主牌
            if(i>=list.size()-3){
                list4.add(list.get(i));
                continue;
            }
            if(i%3==0){
                list1.add(list.get(i));
            }else if(i%3==1){
                list2.add(list.get(i));
            }else {
                list3.add(list.get(i));
            }
        }

        System.out.println("aa "+list1+" "+list1.size());
        System.out.println("bb "+list2+" "+list2.size());
        System.out.println("cc "+list3+" "+list3.size());
        System.out.println("底牌 "+list4+" "+list4.size());

    }


    private static List<String> shuffleCard(){
        List<String> list= new ArrayList<>();
        //1.创建54张牌
        String[] color = {"黑桃", "红桃", "梅花", "方块"};
        int[] num = new int[13];
        for (int i = 1; i < 14; i++) {
            num[i-1] = i;
        }
        String[] King = {"大王", "小王"};



        //foreach 简单点
        for(String temp:color){
            for(int n:num){
                list.add(temp+n);
            }
        }
        /*
        for(int i=0;i<color.length;i++){

            for(int j=0;j<num.length;j++){
                list.add(color[i]+num[j]);
            }
        }*/
        list.add(King[0]);
        list.add(King[1]);

        System.out.println(list);

        Collections.shuffle(list);
        System.out.println(list);
        return list;

    }

}
