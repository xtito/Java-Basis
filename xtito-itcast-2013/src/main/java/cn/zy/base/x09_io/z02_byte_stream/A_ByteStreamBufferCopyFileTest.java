package cn.zy.base.x09_io.z02_byte_stream;

import java.io.*;

/**
 * 需求：复制文件，通过字节流已有的缓冲区对象。
 * Created by [Zy]
 * 2016/6/29 16:56
 */
public class A_ByteStreamBufferCopyFileTest {

    public static void main(String[] args) {

        // 复制文件，通过字节流已有的缓冲区对象。
        File srcFile = new File("F:\\test\\tempFile\\file.text");
        File destFile = new File("F:\\test\\tempFile\\copy_file2.text");

        BufferedInputStream buFis = null;
        BufferedOutputStream buFos = null;
        try {
            // 1、创建好流对象。
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            // 2、创建缓冲区对象并和指定的流相关联
            buFis = new BufferedInputStream(fis);
            buFos = new BufferedOutputStream(fos);

            // 创建字节数组
            byte[] buf = new byte[1024];

            int len = 0;
            // 缓冲区的read方法从缓冲区中读取一个字节。
            while ((len = buFis.read(buf)) != -1) {
                // 将一个字节写入到缓冲区中。
                buFos.write(buf, 0, len);
                // 刷新缓冲区，将数据刷到目的地。
                buFos.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (buFis != null) {
                try {
                    // 关闭字节输入缓冲区流资源
                    buFis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (buFos != null) {
                try {
                    // 关闭字节输出缓冲区流资源
                    buFos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
