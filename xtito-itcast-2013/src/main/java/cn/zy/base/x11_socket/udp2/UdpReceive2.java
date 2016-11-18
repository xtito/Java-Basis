package cn.zy.base.x11_socket.udp2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * UDP协议 - 接收端
 * Created by [Zy]
 * 2016/11/17 18:11
 */
public class UdpReceive2 {

    public static void main(String[] args) {

        /**
         * 定义一个UDP的接收端。接收发送过来的数据。并显示在屏幕上
         * 思路：
         * 1、先有udp Socket服务。而且记住：接收端一定要明确端口，否则收不到数据
         * 2、接收数据，之前先将数据存储在数据包中
         * 3、先定义数据包。
         * 4、通过数据包对象获取数据包的内容，发送端的IP
         * 5、关闭资源
         */

        try {
            System.out.println("udp2 接收端 run");

            // 1、先有udp Socket服务
            DatagramSocket ds = new DatagramSocket(19999);

            while (true) {

                // 2、接收数据，之前先将数据存储在数据包中
                // 3、先定义数据包。
                byte[] buf = new byte[1024];
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                ds.receive(dp);// 阻塞

                // 4、通过数据包对象获取数据包的内容，发送端的IP
                String ip = dp.getAddress().getHostAddress();
                int port = dp.getPort();
                String text = new String(dp.getData(), 0, dp.getLength());
                System.out.println("IP：" + ip + ":" + port + "  内容：" + text);

            }


            // 5、关闭资源
//            ds.close();
//            System.out.println("udp2 数据接收完毕");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
