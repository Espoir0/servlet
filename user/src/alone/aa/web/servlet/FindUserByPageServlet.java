package alone.aa.web.servlet;

import alone.aa.domain.PageBean;
import alone.aa.domain.User;
import alone.aa.service.UserService;
import alone.aa.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.获取参数 ,当前所在的页数和每页显示几条
        String page = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        //直接点击默认为第一页
        if(page==null || "".equals(page) || Integer.parseInt(page)<=0){
            page="1";
        }
        if(rows==null || "".equals(rows)){
            rows="5";
        }
        //2.调用service查询
        UserService service=new UserServiceImpl();

        //获取条件查询所用到的参数
        Map<String, String[]> condition = request.getParameterMap();

        PageBean<User> pb=service.findUserByPage(page,rows,condition);
        System.out.println(pb);

        //3.将pageBean存入request域中
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);//将查询条件也存入request中
        //4.转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
