package alone.aa.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context4")
public class ContextDemo4 extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse rep){
        //获取context
        ServletContext context = this.getServletContext();
        //获取共享域中的数据
        Object name = context.getAttribute("name");
        System.out.println(name);

    }
    protected void doGet(HttpServletRequest req, HttpServletResponse rep){
        this.doPost(req,rep);
    }
}
