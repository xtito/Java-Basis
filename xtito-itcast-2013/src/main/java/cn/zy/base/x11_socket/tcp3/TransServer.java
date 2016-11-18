package cn.zy.base.x11_socket.tcp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP 服务端
 *
 * Created by [Zy]
 * 2016/11/18 16:12
 */
public class TransServer {

    public static void main(String[] args) {

        try {

            System.out.println("服务端运行....");

            // 服务端：
            // 思路：
            // 1、创建服务端socket 明确端口。
            ServerSocket ss = new ServerSocket(10005);
            while (true) {
                // 获取客户端对象。
                Socket s = ss.accept();
                System.out.println(s.getInetAddress().getHostAddress()+".....connected");

                // 2、源：socket输入流。读取客户端的发过来的数据。
                BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

                // 3、目的：socket输出流。将转成大写的数据发送给客户端。
                PrintWriter out = new PrintWriter(s.getOutputStream(),true);

                // 4、频繁的读写操作。
                String line = null;
                while ((line = bufIn.readLine()) != null) {
                    if("over".equals(line)){//如果客户端发过来的是over，转换结束。
                        break;
                    }
                    System.out.println(line);
                    // 将读取到的字母数据转成大写，发回给客户端。
                    out.println(line.toUpperCase());
//				    out.flush();
                }
                // 5、关闭客户端。
                s.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
