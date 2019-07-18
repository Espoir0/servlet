package alone.aa.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用动态代理过滤敏感词汇
 */
@WebFilter("/*")
public class SensitiveWordFilter implements Filter {
    //敏感词汇集合
    private List<String> list=new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取文件的真实路径
        ServletContext servletContext = filterConfig.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/word.txt");
        //2.读取文件
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(realPath), "utf-8"));

            // BufferedReader br = new BufferedReader(new FileReader(realPath));
            //将文件的每一行数据添加到list中
            String line=null;
            while ((line=br.readLine())!=null){
                list.add(line);
            }
            br.close();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain) throws IOException, ServletException {
        //1.创建代理对象，增强getParameter方法
        ServletRequest proxy_req =(ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //增强getParamter方法
                        //判断是否是getParameter方法
                        if("getParameter".equals(method.getName())){
                            //增强返回值
                            //获取返回值
                            String value = (String)method.invoke(req, args);
                            if(value!=null){
                                for (String s : list) {
                                    if (value.contains(s)){
                                        value=value.replaceAll(s,"***");
                                    }
                                }
                            }
                            return value;
                        }

                        //判断方法名是否是 getParameterMap
                        //判断方法名是否是 getParameterValue

                        return method.invoke(req,args);
                    }
                });

        //放行
        chain.doFilter(proxy_req,rep);


    }

    @Override
    public void destroy() {

    }
}
