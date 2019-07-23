package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

//流式写法
public class Demo9 {
    public static void main(String[] args) {
        List<String> list = List.of("aa","ccc","ee","ddd","fff","ed");
        List<String> list2 = List.of("zz","eecc","evv","dtttd","nfff","nmd");

        //长度为三，存储到信集合
        ArrayList<String> list3 = new ArrayList<>();
        list.stream().filter(s->s.length()==3).forEach(s-> list3.add(s));

        //前三个
        ArrayList<String> list4 = new ArrayList<>();
        list.stream().limit(3).forEach(s->list4.add(s));

        //只要字符e开头的单词
        ArrayList<String> list5 = new ArrayList<>();
        list.stream().filter(s->s.startsWith("e")).forEach(s->list5.add(s));

        //不要前两个
        ArrayList<String> list6 = new ArrayList<>();
        list.stream().skip(2).forEach(s->list6.add(s));

        //合并
        ArrayList<String> list7 = new ArrayList<>();
        Stream.concat(list.stream(),list2.stream()).forEach(s->list7.add(s));

        ArrayList<Person> list8 = new ArrayList<>();
        list7.stream().map(s->new Person(s));

        list8.stream().forEach(s-> System.out.println(s));




    }
    }


