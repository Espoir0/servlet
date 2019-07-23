package alone.aa.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * filter的执行流程
 *
 */
//浏览器直接请求资源或者转发访问时都会执行
@WebFilter(value = "/index.jsp",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.Forward)
//@WebFilter(value = "/index.jsp",dispatcherTypes = DispatcherType.REQUEST)

public class FilterDemo4 implements Filter {
    /**
     * 在服务器关闭后，Filter对象被销毁，如果服务器正常关闭，则会执行destroy方法
     * 执行一次，释放资源
     */
    public void destroy() {
    }

   /*每一次请求被拦截资源的时候，会执行，执行多次*/
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对req对象的请求消息增强
        System.out.println("filterDemo执行");
        //放行
        chain.doFilter(req, resp);
        //执行完上面的代码后，回到此处再次执行，对resp中的响应消息增强
        System.out.println("filterDemo3回来时执行");
    }

    /**
     *在服务器启动后，会创建Filter对象，然后调用 init方法
     * 执行一次，加载资源
     */
    public void init(FilterConfig config) throws ServletException {

    }

}
