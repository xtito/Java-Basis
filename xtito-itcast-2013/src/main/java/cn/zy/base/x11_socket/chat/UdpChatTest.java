package cn.zy.base.x11_socket.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * 群聊
 * 案例一：通过udp实现群聊程序。 思路： 这个程序中既有收又有发，需要同时执行，需要使用多线程技术。
 * 一个线程负责发，一个线程负责收。需要两个任务。
 * Created by [Zy]
 * 2016/11/17 21:21
 */
public class UdpChatTest {

    public static void main(String[] args) throws SocketException {

        // 发送端需要选建立UDP的socket，并指定发送端端口
        DatagramSocket sendDs = new DatagramSocket(12345);

        // 接收端先有udp Socket服务
        DatagramSocket receiveDs = new DatagramSocket(19999);

        // 创建任务对象
        Send send = new Send(sendDs);
        Receive receive = new Receive(receiveDs);

        // 创建线程并开启。
        Thread t1 = new Thread(send);
        Thread t2 = new Thread(receive);
        t1.start();
        t2.start();
    }
}



// 发送任务
class Send implements Runnable {

    // 1、需要选建立UDP的socket，并指定发送端端口
    private DatagramSocket ds;

    public Send(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {

            // 2、将数据封闭到数据包中，数据包对象是DatagramPacket。数据来自于键盘录入
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            String line = null;

            while ((line = buffer.readLine()) != null) {
                byte[] buf = line.getBytes();// 将数据转换成字节数组
                // 指定要发送的主机
                InetAddress ip = InetAddress.getByName("127.0.0.1");
                // 将字节数组封闭到数据包中
                DatagramPacket dp = new DatagramPacket(buf, buf.length, ip, 19999);

                // 3、使用socket对象的send方法将数据包发送出去。
                ds.send(dp);

                if ("886".equals(line)) {
                    break;
                }
            }

            // 4、关闭资源
            ds.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


// 接收任务
class Receive implements Runnable {

    // 1、先有udp Socket服务
    private DatagramSocket ds;

    public Receive(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {

        while (true) {
            try {
                // 2、接收数据，之前先将数据存储在数据包中
                // 3、先定义数据包。
                byte[] buf = new byte[2048];
                DatagramPacket dp = new DatagramPacket(buf, buf.length);
                ds.receive(dp);// 阻塞

                // 4、通过数据包对象获取数据包的内容，发送端的IP
                String ip = dp.getAddress().getHostAddress();
                int port = dp.getPort();
                String text = new String(dp.getData(), 0, dp.getLength());
                System.out.println("IP：" + ip + ":" + port + "  内容：" + text);

                if(text.equals("886")){
                    System.out.println(ip+"....离开聊天室");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}









































