package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server :响应客户端的请求，读取客户端发送的数据，给客户端写数据
 *
 *  ServerSocket(int port) :绑定指定端口号的服务器，让客户的来连接
 *  服务器必须知道是哪个客户端发起的请求：
 *      server.accept()方法，返回请求的客户端对象
 */
public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket server=new ServerSocket(8888);//创建服务器，绑定端口号

        Socket socket=server.accept();//接收请求的客户端对象

        OutputStream os = socket.getOutputStream();//获取输入流

        InputStream is = socket.getInputStream();

        byte[] data=new byte[1024];
        int len=is.read(data); //读取字节数据到数组中，并返回读到字节个数
        System.out.println(new String(data,0,len));

        os.write("收到，谢谢".getBytes());//给客户端写数据


        socket.close();//释放资源
        server.close();

    }
}
