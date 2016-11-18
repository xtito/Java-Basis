package cn.zy.base.x11_socket.upload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP 图片上传服务端
 *
 * Created by [Zy]
 * 2016/11/18 16:40
 */
public class UploadPicServer {

    public static void main(String[] args) {

        try {
            System.out.println("上传图片服务端运行......");
            // 创建server  socket。
            ServerSocket ss = new ServerSocket(10007);

            while (true) {
                // 获取客户端。
                Socket s = ss.accept();

                //实现多个客户端并发上传，服务器端必须启动做个线程来完成。
                new Thread(new UploadPic(s)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class UploadPic implements Runnable {

    private Socket s;

    public UploadPic(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            String ip = s.getInetAddress().getHostAddress();
            System.out.println(ip + ".....connected");

            // 读取图片数据。
            bis = new BufferedInputStream(s.getInputStream());

            // 写图片数据到文件。
            File dir = new File("F:/test/upload");
            if (!dir.exists()) {
                boolean state = dir.mkdir();
            }
            // 为了避免覆盖，通过给重名的文件进行编号。
            int count = 1;
            File picFile = new File(dir, ip + "(" + count + ").jpg");
            while (picFile.exists()) {
                count++;
                picFile = new File(dir, ip + "(" + count + ").jpg");
            }
            bos = new BufferedOutputStream(new FileOutputStream(picFile));

            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = bis.read(buf)) != -1) {
                bos.write(buf, 0, len);
            }

            // 给客户端一个回馈信息。
            OutputStream out = s.getOutputStream();
            out.write("上传成功".getBytes());

            // 关闭资源。
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
