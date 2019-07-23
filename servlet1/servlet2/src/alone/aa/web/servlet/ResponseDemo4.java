package alone.aa.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置编码，在获取流之前设置
        response.setContentType("utf-8");

        //获取字节输出流
        //response获取的流，不需要刷新，不需要关闭，会自动关闭
        ServletOutputStream sos = response.getOutputStream();
        //输出数据
        sos.write("你好呀".getBytes("utf-8"));//声明要转化成字节的编码
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
