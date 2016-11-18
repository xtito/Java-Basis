package cn.zy.base.x11_socket.tcp2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP 客户端
 * 需求：实现客户端和服务端的收发过程。
 *
 * Created by [Zy]
 * 2016/11/18 9:35
 */
public class TcpClient2 {

    public static void main(String[] args) {

        try {
            System.out.println("客户端2 启动.......");

            // 创建客户端socket对象。明确服务端地址和端口。
            Socket socket = new Socket("127.0.0.1", 10003);

            // 发送数据，通过socket输出流完成。
            OutputStream out = socket.getOutputStream();
            out.write("服务端，我来了".getBytes());

            // 读取服务端返回的数据，通过socket输入流
            InputStream in = socket.getInputStream();
            byte[] buf = new byte[1024];
            int len = in.read(buf);
            String text = new String(buf,0,len);
            System.out.println(text);

            // 4、关闭资源
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
