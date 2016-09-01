package cn.zy.base.x09_io.z01_file;

import java.io.File;
import java.text.DateFormat;
import java.util.Date;

/**
 * File类的方法演示。
 *  获取文件的信息。名称，大小，时间。
 * Created by [Zy]
 * 2016/3/2 13:03
 */
public class FileDemo1 {

    public static void main(String[] args) {

        /*
		 * File类的方法演示。
		 * 获取文件的信息。名称，大小，时间。
		 *
		 */

        File file = new File("F:\\test\\Test22.java");

        // 绝对路径
        String absPath = file.getAbsolutePath();

        // 相对路径
        String path = file.getPath();//File中封装的路径是什么获取到的就是什么。

        // 文件名
        String filename = file.getName();

        // 文件大小
        long size = file.length();

        // 文件修改时间
        long time = file.lastModified();

        System.out.println("absPath="+absPath);// 绝对路径
        System.out.println("path="+path);// 相对路径
        System.out.println("filename="+filename); // 文件名
        System.out.println("size="+size);// 文件大小
        System.out.println("time="+time);// 文件修改时间

//		毫秒值--Date--格式化--字符串文本
        String str_date = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG).format(new Date(time));
        System.out.println(str_date);


    }

}
