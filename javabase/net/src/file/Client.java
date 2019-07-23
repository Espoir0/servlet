package file;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        readFile();
    }

    private static void readFile() throws IOException {
        //本地输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\c++primerplus.pdf"));

        //建立客户端
        Socket client=new Socket("localhost",9999);

        OutputStream os = client.getOutputStream();
        InputStream is = client.getInputStream();

        //从本地读取数据，并且发送给Server
        int len=0;
        byte[] data=new byte[1024];
        while ((len=bis.read(data))!= -1){
            os.write(data,0,len);
        }

        client.shutdownOutput();//结束网络输出流，因为Client没有吧结束标记传给server,需要手动结束

        //接收服务器的message
        byte[] message=new byte[1024];
        int num=is.read(message);
        System.out.println(new String(message,0,num));

        //释放资源
        client.close();
        bis.close();
    }
}
