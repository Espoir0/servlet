package alone.aa.web.servlet;

import alone.aa.domain.Hero;
import alone.aa.service.HeroService;
import alone.aa.service.impl.HeroServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/heroServlet")
public class HeroServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*//1.调用service查询
        HeroService service = new HeroServiceImpl();
        List<Hero> list = service.findAll();

        //2.序列化list为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        System.out.println(json);*/

        HeroService service = new HeroServiceImpl();
        String json = service.findAllJson();
        //3.响应结果
        //设置响应类型为json格式
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
