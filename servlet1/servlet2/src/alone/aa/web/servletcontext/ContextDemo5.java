package alone.aa.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context5")
public class ContextDemo5 extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse rep){
        //获取context
        ServletContext context = this.getServletContext();
        String a = context.getRealPath("/WEB-INF/classes/a.txt");//src目录下的资源访问
        String b = context.getRealPath("/b.txt");//web目录下的资源访问
        String c = context.getRealPath("/WEB-INF/c.txt");//WEB-INF 目录下的资源访问
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }
    protected void doGet(HttpServletRequest req, HttpServletResponse rep){
        this.doPost(req,rep);
    }
}
