package cn.zy.base.x11_socket.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP 客户端
 * 需求：通过TCP传输将数据发送给服务器
 * 思路：
 * 1、建立TCP的客户端Socket。明确服务端的地址和端口。
 * 2、如果通道建立成功会出现Socket IO流
 *      客户端需要做的就获取Socket流中输出流将数据发送目的地服务端。
 * 3、通过Socket输出流将数据发送。
 * 4、关闭资源
 *
 * Created by [Zy]
 * 2016/11/18 9:35
 */
public class TcpClient {

    public static void main(String[] args) {

        try {
            System.out.println("客户端运行.......");

            // 1、建立TCP的客户端Socket。明确服务端的地址和端口。
            Socket socket = new Socket("127.0.0.1", 10003);

            // 2、如果通道建立成功会出现Socket IO流。客户端需要做的就获取Socket流中输出流将数据发送目的地服务端。
            OutputStream out = socket.getOutputStream();

            // 3、通过Socket输出流将数据发送。
            out.write("hello tcp 来了".getBytes());

            // 4、关闭资源
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
