package cn.zy.base.x11_socket.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP 文本文件上传服务端
 * <p/>
 * Created by [Zy]
 * 2016/11/18 16:18
 */
public class UploadTextServer {

    public static void main(String[] args) {

        try {

            System.out.println("上传文本服务端运行....");
            // 服务端：
            // 思路：
            // 1、创建服务端socket 明确端口。
            ServerSocket ss = new ServerSocket(10006);
            while (true) {
                // 获取客户端对象。
                Socket s = ss.accept();
                System.out.println(s.getInetAddress().getHostAddress() + ".....connected");

                // 2、源：socket输入流。读取客户端的发过来的数据。
                BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));

                // 3、目的：文件。
                PrintWriter pw = new PrintWriter(new FileWriter("F:/test/copyJavaList.text"), true);

                // 4、频繁的读写操作。
                String line = null;
                while ((line = bufIn.readLine()) != null) {
                    // 约定结束标记
//				    if("over".equals(line)){
//				    	break;
//				    }
                    pw.println(line);
                }

                // 5、发回给客户端上传成功字样。
                PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                out.println("上传成功");

                // 6、关闭客户端。
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
