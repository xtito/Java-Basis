package cn.zy.base.x09_io.z02_byte_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 演示: 第二个读取方法， read(byte[]);
 * Created by [Zy]
 * 2016/6/29 16:27
 */
public class A_FileInputStreamDemo2 {

    public static void main(String[] args) {

        // 创建要读取的文件
        File file = new File("F:\\test\\tempFile\\file.text");

        FileInputStream fis = null;

        try {
            // 创建一个字节输入流对象,必须明确数据源，其实就是创建字节读取流和数据源相关联。
            fis = new FileInputStream(file);

            // 创建一个字节数组。长度可以定义成1024的整数倍。
            byte[] buf = new byte[1024];


            int len = 0;
            while((len = fis.read(buf)) != -1){
                System.out.println(new String(buf, 0, len));
            }


            /*int len1 = fis.read(buf);
            System.out.println(len1+":"+new String(buf,0,len1));
            int len2 = fis.read(buf);
            System.out.println(len2+":"+new String(buf,0,len2));
            int len3 = fis.read(buf);
            System.out.println(len3+":"+new String(buf,0,len3));
            int len4 = fis.read(buf);
            System.out.println(len4);*/

        } catch (IOException e) {
            System.out.println(e.toString() + "----");
        } finally {
            if (fis != null) {
                try {
                    // 关闭流资源
                    fis.close();
                } catch (IOException e) {
                    System.out.println(e.toString() + "输入流关闭失败");
                }
            }
        }

    }

}
