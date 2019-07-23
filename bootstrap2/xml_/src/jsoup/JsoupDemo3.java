package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {

        //获取路径
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        //获取document对象
        Document document = Jsoup.parse(new File(path),"utf-8");
        //获取标签集合
        Elements elements = document.getElementsByTag("student");
       // System.out.println(elements);  //输出字符串表示形式

        Element element_stu = elements.get(0);//获取所有student元素的的第一个元素
        Elements names = element_stu.getElementsByTag("name");//获取单个student标签下的name标签
        System.out.println(names);
        String number = element_stu.attr("number");//获取number对应的属性值
        System.out.println(number);   //s001

        String text=names.text();   //只获取内容
        System.out.println(text);   //张 三
        String html=names.html();  //获取的是子标签及内容
        System.out.println(html);   //<xing>张</xing><ming>三</ming>

    }

}
