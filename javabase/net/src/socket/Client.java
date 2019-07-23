package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.SocketHandler;

/**
 * 1.客户端向服务器发起请求，给服务器发送数据，接收服务器返回来的数据
 * 2. Socket类：包含了IP地址和端口号
 *
 * Socket(String host,String port),创建一个客户端，将其连接到指定主机的指定端口号
 *   socket.getOutputStream();获取客户端的输出流
 *   os.write()给服务器写数据
 *   socket.getInputStream();获取客户端的输入流
 *   is.read();  //获取来自服务器的数据
 *
 *   close()关闭
 *
 *   注意：服务器和客户端交互时必须使用客户端提供的流，不能自己创建流（区分不同的客户端）
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 8888);
        OutputStream os = client.getOutputStream();
        InputStream is = client.getInputStream();

        os.write("hello".getBytes());

        byte[] data=new byte[1024];
        int len=is.read(data);
        System.out.println(new String (data,0,len));
        client.close();

    }
}
