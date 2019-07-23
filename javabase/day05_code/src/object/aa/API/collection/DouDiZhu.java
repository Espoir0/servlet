package object.aa.API.collection;

import java.util.*;

/**
 * 模拟斗地主发牌：
 *      1.准备54张不同的牌
 *          两个集合。一个集合存储花色，一个集合存储数字。集合不变可用List.of()确定集合 .
 *          将所有牌放入同一个Map当中，
 *      2.洗牌，获取一副牌也就是Map 的key值。
 *              将key值存入List中，Collection.shuffle();进行洗牌
 *      3.发牌：依次将洗好的牌分为三组，用List分别记录每组牌对应的索引，然后对索引进行排序
 *              将排序后的三组牌放入List集合中
 *      4.看牌：玩家在三组牌随机抽取一组索引，依据得到的索引依次获得玩家的每张牌
 *
 */
public class DouDiZhu {
    public static void main(String[] args) {
        Map<Integer, String> pokers = preparaCard();
        List<Integer> list = shufflePoker(pokers);
        sendPoker(pokers,list);
    }

    private static void sendPoker(Map<Integer,String> pokers,List<Integer> list) {

        ArrayList<Integer> list11=new ArrayList<>();
        ArrayList<Integer> list22=new ArrayList<>();
        ArrayList<Integer> list33=new ArrayList<>();
        ArrayList<Integer> list44=new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int index=list.get(i);
            //拿到牌大小的索引，索引大牌就大
            String poker=pokers.get(list.get(i));//获取每一张牌
            if(i>=list.size()-3){
                list44.add(index);
                continue;
            }
            if(i%3==0){
                list11.add(index);

            }else if(i%3==1){
                list22.add(index);

            }else {
                list33.add(index);
            }
        }
        Collections.sort(list11);
        Collections.sort(list22);
        Collections.sort(list33);
        Collections.sort(list44);

        //将三组牌排序后，放入List集合中，给玩家随机发一副牌
        List<ArrayList<Integer>> lists = new ArrayList<>();
        lists.add(list11);
        lists.add(list22);
        lists.add(list33);

        Random random = new Random();
        int a=random.nextInt(3);
        int b=random.nextInt(2);

        seePoker("玩家一",lists.remove(a),pokers);
        seePoker("玩家二",lists.remove(b),pokers);
        seePoker("玩家三",lists.remove(0),pokers);
        seePoker("底牌",list44,pokers);

    }

    private static void  seePoker(String name,List<Integer> list, Map<Integer,String> poekrs) {
        ArrayList<String> list1 = new ArrayList<>();
        int index=0;
        for (int i = 0; i < list.size(); i++) {
            index=list.get(i);

            list1.add(poekrs.get(index));

        }
        System.out.println(name+": "+list1);

    }

    //返回一个与map中的所有key对应的打乱顺序的List
    private static List<Integer> shufflePoker(Map<Integer,String> pokers) {
        //洗牌的时候，Map集合不能打乱，可以准备一个List存储Map中的所有Key值，然后将List打乱
        //发牌的时候，按List中的顺序取map中的  value即可
        //练习用，写的比较复杂，
        List<Integer> list=new ArrayList<>();
        Set<Integer> set=pokers.keySet();
        Iterator<Integer> iter=set.iterator();
        while (iter.hasNext()){
            list.add(iter.next());
        }
        System.out.println(list);
        Collections.shuffle(list);
        return list;

    }

    //准备牌
    private static Map<Integer, String> preparaCard() {
        List<String> color=List.of("♠","♥","♣","♦");
        List<String> num=List.of("2","A","K","Q","j","10","9","8","7","6","5","4","3");
        HashMap<Integer, String> pokers = new HashMap<>();

        pokers.put(0,"大王");
        pokers.put(1,"小王");
        int i=2;
        //依次准备好每张牌放入 map中
        for(String temp2:num){
            for(String temp1:color){
                pokers.put(i,temp1+temp2);
                i++;
            }
        }

        return pokers;

    }
}
