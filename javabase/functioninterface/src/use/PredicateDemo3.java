package use;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * 过滤集合中的元素  ： 名字四个字，且为女生
 */
public class PredicateDemo3 {
    public static void main(String[] args) {
        String[] arr=new String[]{"迪丽热巴,女","赵丽颖,女","aaaa,男","ffff,女"};
        ArrayList<String> list=filter(arr,s->s.split(",")[0].length()==4,s->s.split(",")[1].equals("女"));
        System.out.println(list);
    }

    private static ArrayList<String> filter(String[] arr, Predicate<String> pre1,Predicate<String> pre) {
        ArrayList<String> list = new ArrayList<>();
        for (String s : arr) {

            boolean a= pre1.and(pre).test(s);

            if(a){
                list.add(s);
            }
        }

        return list;
    }


}
