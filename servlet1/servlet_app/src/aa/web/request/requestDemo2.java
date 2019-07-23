package aa.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo2")
public class requestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求方法
        String method=request.getMethod();
        System.out.println(method);

        String path=request.getContextPath();   //获取虚拟路经
        System.out.println(path);

        String servletpath=request.getServletPath();//获取servlet路径
        System.out.println(servletpath);

        String name=request.getQueryString();   //获取get的请求参数
        System.out.println(name);

        String URI=request.getRequestURI();         //获取URI 只是标识资源，代表的范围比URL大
        StringBuffer URL=request.getRequestURL();   //获取URL
        System.out.println(URI);
        System.out.println(URL);

        String pro=request.getProtocol();        //获取协议及版本
        System.out.println(pro);

        String remoteAddr=request.getRemoteAddr();   //获取客户机的IP
        System.out.println(remoteAddr);


    }
}
