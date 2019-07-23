package alone.aa.web;

import alone.aa.dao.UserDao;
import alone.aa.modle.PO.User;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        /*//2.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //3.封装user对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/

        //2.获取所有参数
        Map<String, String[]> map = request.getParameterMap();
        //3.创建user对象
        User loginUser=new User();
        //3.2使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //4.创建userDao,并调用login方法
        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);

        //5.判断返回user
        if(user==null){
            //登录失败，通过转发器对象转发，跳转页面
            request.getRequestDispatcher("/failServlet").forward(request,response);
        }else {
            //登录成功
            //存储数据
            request.setAttribute("user",user);
            //通过转发器对象转发，跳转页面
            request.getRequestDispatcher("/successServlet").forward(request,response);

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
