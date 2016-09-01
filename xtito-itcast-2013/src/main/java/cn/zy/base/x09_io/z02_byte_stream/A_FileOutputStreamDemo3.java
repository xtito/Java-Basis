package cn.zy.base.x09_io.z02_byte_stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * IO的异常处理
 * Created by [Zy]
 * 2016/6/29 15:50
 */
public class A_FileOutputStreamDemo3 {

    public static void main(String[] args) {

        // 创建存储数据的文件
        File file = new File("F:\\test\\tempFile\\file.text");
        FileOutputStream fos = null;
        try {
            // 创建一个用于操作文件的字节输出流对象。一创建就必须明确数据存储的目的地。
            fos = new FileOutputStream(file);

            // 调用父类的write方法。
            fos.write("java".getBytes());

        } catch (IOException e) {
            System.out.println(e.toString() + "----");
        } finally {
            if (fos != null) {
                try {
                    // 关闭流资源
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException("输出流关闭失败！");
                }
            }

        }

    }

}
