package jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class Demo5 {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        URL url = Demo4.class.getClassLoader().getResource("student.xml");//获取文件路径
        String path = url.getPath();//获取文件路径的字符串表示形式
        Document document = Jsoup.parse(new File(path),"utf-8");//获取文档树

        //根据document对象创建 JXDocument对象
        JXDocument jxDocument = new JXDocument(document);

        //结合xpath语法查询  //查询所有student标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        for (JXNode jxNode : jxNodes) {
            //System.out.println(jxNode);
        }

        //查询所有student标签下的name 标签
        List<JXNode> jxNodes2 = jxDocument.selN("//student/name");
        for (JXNode jxNode : jxNodes2) {
           // System.out.println(jxNode);
        }

        //查询student标签下的有id的name标签
        List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@id");
        //查询student标签下的有id="it" 的name标签
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id='it']");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }
    }
}
