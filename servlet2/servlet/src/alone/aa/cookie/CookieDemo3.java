package alone.aa.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookieDemo3")
public class CookieDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建cookie
        Cookie cookie = new Cookie("msg", "你好");
        //设置cookie的存活时间
        cookie.setMaxAge(30);//将coolie持久化存储到硬盘，30秒之后会自动删除cookie文件
        //cookie.setMaxAge(0);//删除cookie
       // cookie.setMaxAge(-1);//默认方式，关闭浏览器删除cookie
        //2.发送cookie
        response.addCookie(cookie);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
