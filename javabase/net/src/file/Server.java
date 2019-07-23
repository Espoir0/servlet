package file;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Server {
    public static void main(String[] args) throws IOException {
        writeFile();
    }

    private static void writeFile() throws IOException {

        //判断文件夹是否存在
        File dir = new File("E:\\test");
        if (!dir.exists()){
            dir.mkdir();
        }

        ServerSocket server =new ServerSocket(9999);//创建服务器

        while (true) {
            Socket s = server.accept();//获取客户端对象
            new Thread(new Runnable() {
                @Override
                public void run() {
                        BufferedOutputStream bos=null;
                    try {
                        //随机生成文件名
                        String filename="server"+new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date())+".pdf";


                        bos = new BufferedOutputStream(new FileOutputStream(dir+"\\"+filename));

                        InputStream is = s.getInputStream();//获取网络输入流

                        byte[] data = new byte[1024];
                        int len;

                        while ((len = is.read(data)) != -1) {
                            bos.write(data, 0, len);
                            bos.flush();
                        }

                        s.getOutputStream().write("接收完毕".getBytes()); //给客户端发消息
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            bos.close();
                            s.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        }

    }
}
