package alone.aa.web.servletcontext;



import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context")
public class ContextDemo1 extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse rep){
        //servletContext对象获取，两种方式获取的一样
        ServletContext con = req.getServletContext();
        ServletContext con2 = this.getServletContext();


    }
    protected void doGet(HttpServletRequest req, HttpServletResponse rep){
        this.doPost(req,rep);
    }
}
