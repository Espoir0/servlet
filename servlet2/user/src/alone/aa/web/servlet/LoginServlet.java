package alone.aa.web.servlet;

import alone.aa.domain.User;
import alone.aa.service.UserService;
import alone.aa.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据
        //2.1获取用户填写的验证码
        String verifycode = request.getParameter("verifycode");


        //获取所有的键 name的名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);   //获取name对应的value的值
            System.out.println(name+"  "+value );
        }

        //获取所有参数的name和value组成的map
        Map<String, String[]> map = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entrySet = map.entrySet();
        //key是所有的name，而value是数组，因为一个name可能对应过个value
        Iterator<Map.Entry<String, String[]>> iter = entrySet.iterator();
        while (iter.hasNext()){
            Map.Entry<String, String[]> entry = iter.next();
            System.out.println(entry.getKey()+" "+ Arrays.toString( entry.getValue()));
        }

        //4.验证码检校
        //获取session中存储的验证码
        HttpSession session = request.getSession();
        String checkCode = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//确保验证码一次性
        //进行对比
        if(!checkCode.equalsIgnoreCase(verifycode)){
            //验证码错误
            //提示信息
            request.setAttribute("login_msg","验证码错误");
            //跳转到登录界面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

        //4.封装User对象
        User user = new User();
        //调用BeanUtils封装User
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        //5.调用Service查询
        UserService service = new UserServiceImpl();
        User loginUser=service.login(user);
        System.out.println(loginUser);
        //6.判断是否登录成功
        if (loginUser!=null){
            //登录成功
            //将用户存入session
            session.setAttribute("user",loginUser);
            //跳转页面
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            //登录失败
            //提示信息
            request.setAttribute("login_msg","用户名或密码错误");
            //跳转到登录界面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
