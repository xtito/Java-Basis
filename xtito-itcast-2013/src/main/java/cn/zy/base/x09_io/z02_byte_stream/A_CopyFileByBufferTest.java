package cn.zy.base.x09_io.z02_byte_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 练习：复制文件。
 * 原理；读取一个已有的数据，并将这些读到的数据写入到另一个文件中。
 * Created by [Zy]
 * 2016/6/29 16:45
 */
public class A_CopyFileByBufferTest {

    public static void main(String[] args) {

        /**
         * 思路：
         * 1、明确源和目的。
         * 2、明确字节流 输入流和源相关联，输出流和目的关联。
         * 3、使用输入流的读取方法读取字节，并将字节写入到目的中。
         */
        // 1、明确源和目的。
        File srcFile = new File("F:\\test\\tempFile\\file.text");
        File destFile = new File("F:\\test\\tempFile\\copy_file1.text");

        // 2、明确字节流 输入流和源相关联，输出流和目的关联。
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            // 创建字节数组
            byte[] buf = new byte[1024];

            // 3、 使用输入流的读取方法读取字节，并将字节写入到目的中。
            int len = 0;
            while ((len = fis.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fis != null) {
                try {
                    // 关闭输入流资源
                    fis.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fos != null) {
                try {
                    // 关闭输出流资源
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
