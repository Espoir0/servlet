package alone.aa.web.servlet;

import alone.aa.domain.User;
import alone.aa.service.UserService;
import alone.aa.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 查询所有用户列表
 */
@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.调用UserService完成查询
        UserService service=new UserServiceImpl();
        List<User> users = service.findAll();

        //2.将查找的结果存入request域
        req.setAttribute("users",users);
        //3.转发到list.jsp
        req.getRequestDispatcher("/list.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }


}
