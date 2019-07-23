package alone.aa.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/findUserByUsernameServlet")
public class FindUserByUsernameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("aa");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        HashMap<String, Object> map = new HashMap<>();
        if ("李白".equals(username)){
            map.put("userExist",true);
            map.put("msg","该用户名已存在");
        }else {
            map.put("userExist",false);
            map.put("msg","该用户名可用");
        }
        //将map转化为json
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getWriter(),map); //直接将map转化到流中去
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
