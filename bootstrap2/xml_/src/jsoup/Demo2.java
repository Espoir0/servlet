package jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        /*Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);

*/
        URL url=new URL("http://www.baidu.com");//网络中的一个资源
        Document document = Jsoup.parse(url, 5000);  //获取的html文档，爬虫用
        System.out.println(document);
    }
}
