package cn.zy.base.x11_socket.upload;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * TCP 图片上传客户端
 * <p/>
 * Created by [Zy]
 * 2016/11/18 16:40
 */
public class UploadPicClient {

    public static void main(String[] args) {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {

            System.out.println("上传图片客户端运行......");
            // 1、创建socket。
            Socket s = new Socket("127.0.0.1", 10007);

            // 2、读取源图片。
            File picFile = new File("F:/test/1.jpg");

            // 创建好流对象。
            // 创建缓冲区对象并和指定的流相关联
            bis = new BufferedInputStream(new FileInputStream(picFile));

            // 3、目的是socket 输出流。
            bos = new BufferedOutputStream(s.getOutputStream());

            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = bis.read(buf)) != -1) {
                bos.write(buf, 0, len);
                bos.flush();
            }

            // 告诉服务器端图片数据发送完毕，不要等着读了。
            s.shutdownOutput();

            // 读取上传成功字样。
            InputStream in = s.getInputStream();
            byte[] bufIn = new byte[1024];
            int lenIn = in.read(bufIn);
            String text = new String(bufIn, 0, lenIn, "UTF-8");
            System.out.println(text);


            // 关闭。
//            fis.close();
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
