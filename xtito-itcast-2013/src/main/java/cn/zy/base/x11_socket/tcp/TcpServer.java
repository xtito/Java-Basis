package cn.zy.base.x11_socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP服务端
 * 需求：获取客户端的数据并显示在屏幕上。
 * 思路：
 * 1、创建服务端的socket。明确端口，监听一个端口。
 * 2、服务端只要获取到连接过来的客户端就可以和指定的客户端通信了。
 * 3、通过获取客户端的读取流对象读取客户端发来的数据。
 * 4、并显示屏幕上。
 *
 *
 * Created by [Zy]
 * 2016/11/18 9:35
 */
public class TcpServer {

    public static void main(String[] args) {

        try {
            System.out.println("服务端开启.....");

            // 1、创建服务端的socket。明确端口，监听一个端口。
            ServerSocket ss = new ServerSocket(10003);

            while (true) {
                // 2、服务端只要获取到连接过来的客户端就可以和指定的客户端通信了。
                Socket s = ss.accept();// 阻塞，并发时会导致等待
                String ip = s.getInetAddress().getHostAddress();
                System.out.println(ip + ".....connected");

                // 3、通过获取客户端的读取流对象读取客户端发来的数据。
                InputStream in = s.getInputStream();

                // 4、并显示屏幕上。
                byte[] buf = new byte[1024];
                int len = in.read(buf);
                String text = new String(buf, 0, len);
                System.out.println(text);

                // 5,关闭资源。
                s.close();// 关闭客户端，断开连接释放资源
            }

//            ss.close();// 一般服务端不关闭
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}











































