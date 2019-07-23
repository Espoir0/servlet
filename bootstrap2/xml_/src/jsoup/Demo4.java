package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import javax.xml.bind.Element;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Demo4 {
    public static void main(String[] args) throws IOException {
        URL url = Demo4.class.getClassLoader().getResource("student.xml");//获取文件路径
        String path = url.getPath();//获取文件路径的字符串表示形式
        Document document = Jsoup.parse(new File(path),"utf-8");//获取文档树
        Elements names = document.select("name");//选择所有name标签


        //查找id为 it的标签
        Elements elements = document.select("#it");

        //获取student标签，并获取number属性为 001的age 字标签
        Elements ele_age = document.select("student[number='s001']> age");
        System.out.println(ele_age);


    }
}
