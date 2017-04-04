package cn.zy.base.x11_socket.tcp4;

import cn.zy.base.x11_socket.entity.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by [Zy]
 * 2016/11/24 19:50
 */
public class EntityClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("127.0.0.1", 7777);
            //建立输入流
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            User user = new User();
            user.setName("梁国俏");
            user.setPassword("123456");
            user.put("name", "王五");
//            user.setIs(new FileInputStream(new File("F:/test/a.text")));
            //输入对象, 一定要flush（）
            oos.writeObject(user);
            oos.flush();

            oos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
