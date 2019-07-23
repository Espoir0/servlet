package bs;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8080);//创建服务器,指定端口


        while (true) {
            //接收浏览器请求
            Socket socket = server.accept();

            //请求文件中有一张图片，浏览器就会开一个线程请求
            new Thread(new Runnable() {
                @Override
                public void run() {
                    FileInputStream fis=null;//本地输入流


                    try {
                        InputStream is = socket.getInputStream();           //获取浏览器的流

                        BufferedReader bf = new BufferedReader(new InputStreamReader(is));   //将流包装为字符缓冲流，方便获取请求第一行的内容

                        /*int len = 0;
                        byte[] data = new byte[1024];
                        while ((len = is.read(data)) != -1) {
                            System.out.println(new String(data, 0, len));
                        }*/

                        String data = bf.readLine();//读一行，返回的内容没有换行符


                        String[] arr = data.split(" ");      //用空格分隔内容
                        String html = arr[1].substring(1);           //去掉第一个斜杠，求子字符串,获得请求的文件

                        fis = new FileInputStream(new File(html).getAbsolutePath());

                        OutputStream os = socket.getOutputStream();                                  //网络输出流

                        //写入http响应头
                        os.write("http/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());
                        os.write("\r\n".getBytes());               //写入空行，否则http不解析


                        int len = 0;
                        byte[] index = new byte[1024];
                        while ((len = fis.read(index)) != -1) {
                            os.write(index, 0, len);
                        }


                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            fis.close();
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }).start();

            //server.close();


        }
    }
}
