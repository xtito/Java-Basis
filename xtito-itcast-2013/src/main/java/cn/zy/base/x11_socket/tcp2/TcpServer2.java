package cn.zy.base.x11_socket.tcp2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务端
 * 实现客户端和服务端的收发过程。 服务器端。
 *
 * Created by [Zy]
 * 2016/11/18 9:35
 */
public class TcpServer2 {

    public static void main(String[] args) {

        try {
            System.out.println("服务端2  启动.....");

            // 创建tcp服务端socket 明确端口。
            ServerSocket ss = new ServerSocket(10003);

            while (true) {
                // 获取客户端对象。
                Socket s = ss.accept();// 阻塞，并发时会导致等待
                String ip = s.getInetAddress().getHostAddress();
                System.out.println(ip + ".....connected");

                // 读取客户端的发送过来的数据
                InputStream in = s.getInputStream();
                byte[] buf = new byte[1024];
                int len = in.read(buf);
                String text = new String(buf, 0, len);
                System.out.println(text);

                // 给客户端回馈数据。
                OutputStream out = s.getOutputStream();
                out.write("客户端2，我已到收到，哦耶！".getBytes());

                // 5,关闭资源。
                s.close();// 关闭客户端，断开连接释放资源
            }

//            ss.close();// 关闭服务端。如果不断的获取客户端，不用关闭服务端。
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}











































