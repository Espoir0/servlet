package alone.aa.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登录验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements javax.servlet.Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.强制转换,httpservlet有获取uri的方法，
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //2.获取资源的请求路径
        String uri = req.getRequestURI();
        //判断是否包含登录相关的资源路径，要排除掉 css/js/图片/验证码等资源
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/js/") ||
                uri.contains("/css/") || uri.contains("/font/") ||uri.contains("/checkCodeServlet")){
            //包含，用户就是想登录，放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            //不包含，需要验证用户是否登录
            //3.从session中获取user
            Object user = req.getSession().getAttribute("user");
            if (user!=null){
                //登录了，放行
                filterChain.doFilter(servletRequest,servletResponse);
            }else {
                //没有登录跳转到登录页面
                req.setAttribute("login_msg","尚未登录，请登录");
                req.getRequestDispatcher("/login.jsp").forward(req,servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
