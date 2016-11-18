package cn.zy.base.x11_socket.ip;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * IP 地址对象  InetAddress
 * Created by [Zy]
 * 2016/11/17 18:03
 */
public class IPDemo {

    public static void main(String[] args) {

        /**
         * IP 地址对象  InetAddress
         */

        try {
            // 获取本机主机地址对象
//            InetAddress ip = InetAddress.getLocalHost();

            // 获取其他地址的主机对象
            InetAddress ip = InetAddress.getByName("10.1.1.6");

            System.out.println("主机名：" + ip.getHostName() + "  IP：" + ip.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("未找到该主机");
        }

    }

}
