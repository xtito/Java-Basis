package cn.zy.base.x09_io.z02_byte_stream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节输入流。available()方法的使用
 * Created by [Zy]
 * 2016/6/29 16:48
 */
public class A_ByteStreamDemo {

    public static void main(String[] args) {

        // 如何使用 available() 方法
        FileInputStream fis = null;

        try {
            fis = new FileInputStream("F:\\test\\tempFile\\file.text");
//            System.out.println(fis.available());

            //定义了一个刚刚好的数组。 注意：如果文件过大，容易溢出。
            //建议缓冲区的长度最好还是1024的整数倍。
            byte[] buf = new byte[fis.available()];

            int len = fis.read(buf);

            String str = new String(buf);
            System.out.println(str);

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
        }

    }
}
