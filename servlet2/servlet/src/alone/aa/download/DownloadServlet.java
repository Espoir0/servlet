package alone.aa.download;

import alone.aa.util.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数文件名称
        String filename = request.getParameter("filename");
        //2.使用字节流将文件加载进内存
        //找到文件的服务器路径
        ServletContext servletContext = this.getServletContext();
        System.out.println(servletContext);
        //获取真实路径
        String realPath = servletContext.getRealPath("/img/"+filename);
        System.out.println(realPath);

        //用字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        //3.设置response的响应头
        //3.1设置响应头类型 content-type
        String mimeType = servletContext.getMimeType(filename);//获取文件类型
        response.setHeader("content-type",mimeType);
        //设置响应头的打开方式 content-disposition

        //解决中文文件名乱码问题
        //获取user-agent请求头
        String header = request.getHeader("user-agent");
        filename = DownLoadUtils.getFileName(header, filename);


        response.setHeader("content-disposition","attachment;filename="+filename);//以附件形式打开，并设置文件名

        //将输入流的数据写到输出流中
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff=new byte[1024*8];
        int len=0;
        while((len=fis.read(buff))!=-1){
            sos.write(buff,0,len);
        }
        fis.close();


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
