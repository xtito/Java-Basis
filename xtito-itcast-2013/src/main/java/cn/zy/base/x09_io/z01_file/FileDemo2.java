package cn.zy.base.x09_io.z01_file;

import java.io.File;
import java.io.IOException;

/**
 * 对文件或者文件加进行操作。
 * Created by [Zy]
 * 2016/3/8 22:40
 */
public class FileDemo2 {
    public static void main(String[] args) throws IOException {

        /*
		 * File类中的方法2.
		 *
		 * 对文件或者文件加进行操作。
		 */
        File file = new File("F:\\test\\a.text");

        /*
		 * 创建文件，如果文件不存在，创建 true
		 * 如果文件存在，则不创建 false。 如果路径错误，IOException。
		 */
        boolean b1 = file.createNewFile();
        System.out.println("b1: " + b1);

        // 删除
//        boolean b2 = file.delete();// 注意：不去回收站。慎用
//        System.out.println("b2: " + b2);

        // 需要判断文件是否存在
        boolean b3 = file.exists();
        System.out.println("b3: " + b3);

        // 对目录操作 创建，删除，判断
        File dir = new File("F:\\test\\ab");
        boolean b4 = dir.mkdir();
        System.out.println("b4: " + b4);


        File dirs = new File("F:\\test\\ac\\b\\a");
        // 创建多级目录
        boolean b5 = dirs.mkdirs();
        System.out.println("b5: " + b5);

        // 删除目录时，如果目录中有内容，无法直接删除
        boolean b6 = dirs.delete();
        // 只有将目录中的内容都删除后，保证该目录为空。这时这个目录才可以删除。
        System.out.println("b6: " + b6);


        System.out.println("-----------判断文件，目录------------");
        File f = new File("F:\\test\\abc.text");//要判断是否是文件还是目录，必须先判断存在。
        // 是否存在
        boolean b7 = f.exists();
        if (!b7) {
//            boolean b8 = f.mkdir();// 创建文件夹
//            System.out.println("b8: " + b8);
            boolean b9 = f.createNewFile();// 创建文件
            System.out.println("b9: " + b9);
        }

        System.out.println("是否是文件： " + f.isFile());
        System.out.println("是否是文件夹： " + f.isDirectory());

    }
}
