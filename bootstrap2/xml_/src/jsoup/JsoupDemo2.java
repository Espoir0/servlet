package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {

        //获取路径
        String path = JsoupDemo2.class.getClassLoader().getResource("student.xml").getPath();
        //获取document对象
        Document document = Jsoup.parse(new File(path),"utf-8");
        //获取标签集合
        Elements elements = document.getElementsByTag("student");
       // System.out.println(elements);  //输出字符串表示形式

        Element elementById = document.getElementById("it");
        System.out.println(elementById);

        Elements elems=document.getElementsByAttribute("id");
        System.out.println(elems);

        Elements elementsByAttributeValue = document.getElementsByAttributeValue("number", "s001");
        System.out.println(elementsByAttributeValue);

    }

}
