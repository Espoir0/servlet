package alone.aa.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建一个对象，在内存中图片（验证码图片对象）
        int width=100;
        int height=50;
        BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        //2.1填充背景色
        Graphics g = image.getGraphics();//获取画笔对象
        g.setColor(Color.pink);  //设置画笔颜色
        g.fillRect(0,0,width,height); //填充背景

        //2.2画边框
        g.setColor(Color.blue);
        g.drawRect(0,0,width-1,height-1);//边框自身有颜色需要-1

        //创建验证码
        String code="ABCDEFGHIJKLMNOPQISTUVWXYZ0123456789zxcvbnmasdfghjklqwertyuiop";

        Random random = new Random();
        for (int i = 1; i <= 4; i++) {
            //获取随机字符

            int index = random.nextInt(code.length());
            char c = code.charAt(index);
            //2.3写验证码
            g.drawString(c+"",width/5*i,height/2);
        }

        //2.4画干扰线
        g.setColor(Color.GREEN);
        //随机生成坐标点
        for (int i = 0; i < 4; i++) {
            int x1=random.nextInt(width);
            int y1=random.nextInt(height);
            int x2=random.nextInt(width);
            int y2=random.nextInt(height);
            g.drawLine(x1,y1,x2,y2);
        }



        //3.将图片输出到页面展示
        ImageIO.write(image,"jpg",response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
