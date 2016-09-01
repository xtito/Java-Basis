package cn.zy.base.x09_io.z01_file;

import java.io.File;

/**
 * 如何创建文件对象。
 * Created by [Zy]
 * 2016/3/2 13:00
 */
public class FileDemo {

    public static void main(String[] args) {

        /*
		 * File类的构造函数。
		 * 如何创建文件对象。
		 */
        String pathName = "e:\\java_code\\day22e\\hello.java";
        File f1 = new File(pathName);//将Test22文件封装成File对象。注意；有可以封装不存在文件或者文件夹，变成对象。
        System.out.println(f1);


        File f2 = new File("e:\\java_code\\day22e","hello.java");
        System.out.println(f2);

        //将parent封装成file对象。
        File dir = new File("e:\\java_code\\day22e");
        File f3 = new File(dir,"hello.java");
        System.out.println(f3);


//		File f4 = new File("e:"+FILE_SEPARATOR+"java_code"+FILE_SEPARATOR+"day22e"+FILE_SEPARATOR+"hello.java");
        File f5 = new File("e:"+File.separator+"java_code"+File.separator+"day22e"+File.separator+"hello.java");



    }

}
