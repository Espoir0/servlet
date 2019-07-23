package alone.aa.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向
 */
@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo1");
        //访问该资源的时候，会自动跳转到responseDemo2 资源
        //1.设置状态码为302
        //response.setStatus(302);
        //设置响应头location
        //response.setHeader("location","/servlet2/responseDemo2");
        //简单方法，底层就是上面两行代码
        response.sendRedirect("/servlet2/responseDemo2");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
