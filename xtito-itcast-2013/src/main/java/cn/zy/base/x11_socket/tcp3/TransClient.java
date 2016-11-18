package cn.zy.base.x11_socket.tcp3;

import java.io.*;
import java.net.Socket;

/**
 * TCP 客户端
 * 需求：大小写转换，客户端输入小写字母，服务器端返回大写字母
 * 思路：
 * 1、创建socket，明确地址和端口。
 * 2、源：键盘录入。获取需要转换的数据。
 * 3、目的：网络，socket输出流。将录入的数据发送到服务端。
 * 4、源：socket，socket读取流，读取服务端发回来的大写数据。
 * 5、目的：客户端显示器，将大写数据显示出来。直接使用输出语句。
 * 6、频繁的读写操作。
 * 7、关闭资源。
 *
 * Created by [Zy]
 * 2016/11/18 16:04
 */
public class TransClient {

    public static void main(String[] args) {

        try {
            System.out.println("客户端运行......");

            // 1、创建socket，明确地址和端口。
            Socket s = new Socket("127.0.0.1", 10005);

            // 2、源：键盘录入。获取需要转换的数据。
            BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

            // 3、目的：网络，socket输出流。将录入的数据发送到服务端。
            // OutputStream out = s.getOutputStream();
            // 既然都是字符数据，为了便于操作，使用额外功能，转换。同时提高效率。
            // BufferedWriter bufOut = new BufferedWriter(new OutputStreamWriter(out));可以使用打印流
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);// 自带缓冲区，true自动刷新

            // 4、源：socket，socket读取流，读取服务端发回来的大写数据。
//            InputStream in = s.getInputStream();
            BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

            // 5、目的：客户端显示器，将大写数据显示出来。直接使用输出语句。


            // 6、频繁的读写操作。
            String line = null;
            while((line=bufr.readLine())!=null){
                //将读取键盘的数据发送到服务端。
                out.println(line);
//			    out.flush();
                if("over".equals(line)){
                    break;
                }

                //读取服务端返回的数据。
                String upperText = bufIn.readLine();
                System.out.println(upperText);
            }

            // 7、关闭资源。
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
