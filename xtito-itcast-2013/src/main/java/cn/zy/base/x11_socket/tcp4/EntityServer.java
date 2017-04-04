package cn.zy.base.x11_socket.tcp4;

import cn.zy.base.x11_socket.entity.User;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by [Zy]
 * 2016/11/24 19:51
 */
public class EntityServer {

    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(7777);
            System.out.println("start to accept...");
            Socket socket = ss.accept();

            /*
             * 传输实体对象需要注意：
             * 1、实体类必须实现Serializable序列化，实体类中的实体引用也必须Serializable
             * 2、客户端和服务端实体类必须一样，所有属性一样，类的包名也必须一样
             * 3、发送对象之后要flush()(最好刷新)
             */

            //建立输入流
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            Object obj = ois.readObject();
            if (obj != null) {
                User user = (User)obj;//把接收到的对象转化为user
                System.out.println("user: " + user.getName());
                System.out.println("password: " + user.getPassword());
                System.out.println("map[name]: " + user.getParam().get("name"));
            }
            ois.close();
            socket.close();
            ss.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}