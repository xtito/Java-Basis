package cn.zy.base.x09_io.z01_file;

import java.io.File;

/**
 * File类的listFiles()列出当前目录下文件以及文件夹。
 * Created by [Zy]
 * 2016/5/5 18:10
 */
public class GetAllFile {

    public static void main(String[] args) {

        /*
		 * File类的listFiles()列出当前目录下文件以及文件夹。
		 *
		 * 需求：能不能列出当前目录下的子目录中的所有内容。
		 * 思路： 1，在遍历当前目录时，会获取到当前的所有的文件以及文件夹，
		 *       2，要遍历子目录需要对获取到的当前的file对象进行判断，只有是目录才可以作为子目录进行继续遍历。
		 */
        File dir = new File("F:\\test");

        listAll(dir);

    }

    public static void listAll(File dir) {

        System.out.println("dir: " + dir.getName());

        File[] files = dir.listFiles();

        if (files != null && files.length > 0) {
            for (File file:files) {
                // 如果遍历到当前的file对象是个目录，继续遍历。
                if (file.isDirectory()) {
                    listAll(file);
                } else {
                    System.out.println("file: " + file.getName());
                }
            }
        }
    }
}
