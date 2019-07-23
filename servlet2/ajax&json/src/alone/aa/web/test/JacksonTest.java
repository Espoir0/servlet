package alone.aa.web.test;

import alone.aa.web.domain.Hero;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class JacksonTest {
    //将java对象转化为json字符串
    @Test
    public void test() throws IOException {
        //1. 创建Hero对象
        Hero hero = new Hero("李白","青莲剑歌","2",new Date());
        //创建jackson核心对象
        ObjectMapper mapper = new ObjectMapper();
        //3.转换
        /*1. 转换方法：
			* writeValue(参数1，obj):
                    参数1：
                    File：将obj对象转换为JSON字符串，并保存到指定的文件中
                    Writer：将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
                    OutputStream：将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
             * writeValueAsString(obj):将对象转为json字符串
        */

        String json = mapper.writeValueAsString(hero);
        System.out.println(json);

        //2.将数据写到文件中
        mapper.writeValue(new File("E://a.txt"),hero);
        //3.将数据关联到Writer中
        mapper.writeValue(new FileWriter("E://b.txt"),hero);


    }

    @Test
    public void test2() throws JsonProcessingException {
        Hero hero = new Hero("李白","青莲剑歌","2",new Date());
        HashMap<String, Hero> map = new HashMap<>();
        map.put("hero",hero);
        map.put("hero2",hero);
        ObjectMapper mapper = new ObjectMapper();
        String m = mapper.writeValueAsString(map);
        System.out.println(m);

        ArrayList<Hero> list = new ArrayList<>();
        list.add(hero);
        list.add(hero);
        String l = mapper.writeValueAsString(list);
        System.out.println(l);

    }
    @Test
    public void test3() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"name\":\"李白\",\"skill\":\"青莲剑歌\"}";
        Hero hero = mapper.readValue(json, Hero.class);
        System.out.println(hero);
    }


}
