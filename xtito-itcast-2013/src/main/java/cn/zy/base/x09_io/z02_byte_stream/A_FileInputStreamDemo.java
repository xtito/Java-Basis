package cn.zy.base.x09_io.z02_byte_stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 需求：读取文件中的数据，显示在屏幕上。
 * Created by [Zy]
 * 2016/6/29 16:20
 */
public class A_FileInputStreamDemo {

    public static void main(String[] args) {

        // 创建要读取的文件
        File file = new File("F:\\test\\tempFile\\file.text");

        FileInputStream fis = null;

        try {
            // 创建一个字节输入流对象,必须明确数据源，其实就是创建字节读取流和数据源相关联。
            fis = new FileInputStream(file);

            // 读取数据。使用 read();一次读一个字节。
            int ch = 0;
            while((ch=fis.read())!=-1){
                System.out.println("ch="+(char)ch);
            }

            /*int ch1 = fis.read();
            System.out.println("ch1="+(char)ch1);
            int ch2 = fis.read();
            System.out.println("ch2="+(char)ch2);
            int ch3 = fis.read();
            System.out.println("ch3="+(char)ch3);
            int ch4 = fis.read();
            System.out.println("ch4="+(char)ch4);
            int ch5 = fis.read();
            System.out.println("ch5="+(char)ch5);
            int ch6 = fis.read();
            System.out.println("ch6="+ch6);
            int ch7 = fis.read();
            System.out.println("ch7="+ch7);*/

        } catch (IOException e) {
            System.out.println(e.toString() + "----");
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println(e.toString() + "输入流关闭失败");
                }
            }
        }

    }

}
