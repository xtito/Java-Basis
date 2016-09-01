package cn.zy.base.x09_io.z02_byte_stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 需求：将数据写入到文件中
 * Created by [Zy]
 * 2016/6/29 15:21
 */
public class A_FileOutputStreamDemo {

    public static void main(String[] args) throws IOException {

        // 创建临时目录
        File dir = new File("F:\\test\\tempFile");

        // 如果该路径不存在，就创建
        if (!dir.exists()) {
            boolean createOk = dir.mkdir();
        }


        // 创建存储数据的文件
        File file = new File(dir, "file.text");

        // 创建一个用于操作文件的字节输出流对象。一创建就必须明确数据存储的目的地。
        // 输出流目的是文件，会自动创建。如果文件存在，则覆盖。
        FileOutputStream fos = new FileOutputStream(file);

        // 调用父类的write方法。
        byte[] data = "abcde".getBytes();
        fos.write(data);

        // 关闭流资源
        fos.close();

    }

}
