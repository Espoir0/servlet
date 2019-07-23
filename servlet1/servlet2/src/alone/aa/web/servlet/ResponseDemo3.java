package alone.aa.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo3")
public class ResponseDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取流对象之前，设置流的默认编码，ISO-8859-1设置为 GBK
        //response.setCharacterEncoding("GBK");
        //告诉浏览器，服务器发送的消息体数据体的编码，建议浏览器使用该编码
        //response.setHeader("content-type","text/html;charset=utf-8");
        //简化写法，在获取流之前设置
        response.setContentType("utf-8");

        //获取字符输出流
        //response获取的流，不需要刷新，不需要关闭，会自动关闭
        PrintWriter pw = response.getWriter();
        //输出数据
        pw.write("你好呀");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
