package alone.aa.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context3")
public class ContextDemo3 extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse rep){
        //获取context
        ServletContext context = this.getServletContext();
        //在共享域中存储数据
        context.setAttribute("name","aa");


    }
    protected void doGet(HttpServletRequest req, HttpServletResponse rep){
        this.doPost(req,rep);
    }
}
