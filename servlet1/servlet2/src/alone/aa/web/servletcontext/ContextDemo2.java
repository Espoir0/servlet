package alone.aa.web.servletcontext;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/context2")
public class ContextDemo2 extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse rep){
        //获取context
        ServletContext context = this.getServletContext();
        //定义文件名称
        String filename="a.jpg";
        //获取MIME类型
        String mimeType = context.getMimeType(filename);
        System.out.println(mimeType);//image/jpeg


    }
    protected void doGet(HttpServletRequest req, HttpServletResponse rep){
        this.doPost(req,rep);
    }
}
