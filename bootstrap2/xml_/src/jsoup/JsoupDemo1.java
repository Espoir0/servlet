package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        //1.导包 新建libs ，复制jar包，并添加到library
        //2.获取Document对象
        //2.1获取student.xml的path.类加载器
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档,把文件加载进内存，获得DOM树，--》Document
        Document document = Jsoup.parse(new File(path), "utf-8");

        //获取元素对象Element ,该对象是一个类似ArrayList的数组，
        Elements elements = document.getElementsByTag("name");
        //获取name的第一个Element对象
        Element element=elements.get(0);

        //获取数据
        String name=element.text();
        System.out.println(name);
    }
}
