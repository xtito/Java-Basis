package cn.zy.base.x11_socket.udp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

/**
 * UDP协议 - 发送端
 * Created by [Zy]
 * 2016/11/17 18:09
 */
public class UdpSend2 {

    public static void main(String[] args) {

        System.out.println("udp2 发送端 启动。。。");

        /**
         * 通过查阅API文档，了解到用于UDP传输协议的对象是DatagramSocket。
         * 通过UDP的协议发送一段文本数据
         * 思路：
         * 1、需要选建立UDP的socket
         * 2、将数据封闭到数据包中，数据包对象是DatagramPacket。
         * 3、使用socket对象的send方法将数据包发送出去。
         * 4、关闭资源
         */
        try {

            // 等同于上面
            // 1、需要选建立UDP的socket，并指定发送端端口
            DatagramSocket ds = new DatagramSocket(12345);

            // 2、将数据封闭到数据包中，数据包对象是DatagramPacket。数据来自于键盘录入
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            String line = null;

            while ((line = buffer.readLine()) != null) {
                if ("over".equals(line)) {
                    break;
                }

                byte[] buf = line.getBytes();
                // 指定要发送的主机  .255是广播段
                InetAddress ip = InetAddress.getByName("10.1.1.110");

                // 将字节数组封闭到数据包中
                DatagramPacket dp = new DatagramPacket(buf, buf.length, ip, 19999);

                // 3、使用socket对象的send方法将数据包发送出去。
                ds.send(dp);
            }

            // 4、关闭资源
            ds.close();
            System.out.println("udp2 发送完毕");

        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
            System.out.println("没有找到该主机");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
