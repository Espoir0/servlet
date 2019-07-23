package aa.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求头的数据 user-agent
        String agent=request.getHeader("user-agent");
        //判断浏览器的版本
        if(agent.contains("Chrome")){
            //判断是否为谷歌
            System.out.println("chrome");
        }else if (agent.contains("Firefox")){
            //判断是否为火狐
        }

    }
}
