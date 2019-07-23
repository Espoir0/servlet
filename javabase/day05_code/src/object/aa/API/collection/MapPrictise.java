package object.aa.API.collection;

import java.util.HashMap;

/**
 * 统计字符串中每个字符出现的频率
 * 1.将字符串转化为字符数组
 * 2.定义一个map，如果map中不存在该字符时，直接将字符放入map中，对应的value+1；
 */
public class MapPrictise {
    public static void main(String[] args) {

        String s="aabbccc3***???///aabb";
        numberOfStatistics(s);
        numberOfStatistics2(s);

    }

    private static void numberOfStatistics2(String s) {
        //定义map存放字符和出现的频率
        HashMap<Character, Integer> map = new HashMap<>();

        //将字符串转为字符数组
        char[] chars = s.toCharArray();

        //利用map的key值不可重复，统计每个字符出现的次数
        for (int i = 0; i < chars.length; i++) {
            int value=0;
            if(null==map.get(chars[i])){
                map.put(chars[i],(value+1));
            }else {
                value=map.get(chars[i]);
                value++;
                map.put(chars[i],value);
            }
        }
        System.out.println(map);
    }

    private static void numberOfStatistics(String s) {

        //定义map存放字符和出现的频率
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0,value=0; i < s.length(); i++) {
            char c=s.charAt(i);

            //if(map.containsKey(c)){}  还可以通过该方法判断map中是否存在 key
            if(null==map.get(c)){
                map.put(c,1);//
            }else {
                value=map.get(c);
                value++;
                map.put(c,value);
            }
        }
        System.out.println(map);
    }
}
