package aa.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/requestDemo7")
public class RequestDemo7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo7被访问了");
        Object value = request.getAttribute("msg");
        System.out.println(value);

        /*//request.setCharacterEncoding("utf-8"); //乱码解决方法
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entrySet = parameterMap.entrySet();
        //key是所有的name，而value是数组，因为一个name可能对应过个value
        Iterator<Map.Entry<String, String[]>> iter = entrySet.iterator();
        while (iter.hasNext()){
            Map.Entry<String, String[]> entry = iter.next();
            System.out.println(entry.getKey());
            String[] values = entry.getValue();
            for (String value : values) {
                System.out.print(value+" ");
            }
        }*/


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* System.out.println(request);
        String[] hobbies=request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }*/
       //获取所有的键 name的名称
      /*  Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);
            System.out.println(name+"  "+value );
        }*/
        this.doPost(request,response);


    }
}
