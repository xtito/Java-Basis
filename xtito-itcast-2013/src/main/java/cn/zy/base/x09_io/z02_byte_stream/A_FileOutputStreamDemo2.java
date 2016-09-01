package cn.zy.base.x09_io.z02_byte_stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 需求：将数据续写到已有文件中。
 * Created by [Zy]
 * 2016/6/29 15:41
 */
public class A_FileOutputStreamDemo2 {

    // 定义换行
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public static void main(String[] args) throws IOException {

        // 创建存储数据的文件
        File file = new File("F:\\test\\tempFile\\file.text");

        // true 代表续写
        FileOutputStream fos = new FileOutputStream(file, true);

        // 定义换行字符
        String str = LINE_SEPARATOR + "itcast";

        // 调用父类的write方法。
        fos.write(str.getBytes());

        // 关闭流资源
        fos.close();

    }

}
