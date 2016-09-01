package cn.zy.base.x09_io.z01_file.test;

import java.io.File;

/**
 * 需求：请删除一个带有内容的目录。
 * Created by [Zy]
 * 2016/6/30 10:20
 */
public class A_DeleteDirTest {

    public static void main(String[] args) {


        /**
		 * 思路:
		 * 1、删除一个带有内容的目录原理；必须从里往外删。
         * 2、到底有多级目录不确定，递归。
		 */
        File dir = new File("F:\\test\\cc");
        // 直接删是不成功的，必须从最里面往外删
//        System.out.println(dir.delete());

        removeDir(dir);
    }


    /**
     * 删除一个目录及下面所有文件和文件夹
     * @param dir 要删除的目录
     */
    private static void removeDir(File dir) {

        // 1、列出当前目录下的文件以及文件夹File[]
        File[] files = dir.listFiles();

        // 如果目录是系统级文件夹，java没有访问权限，那么会返回null数组。最好加入判断。
        if (files != null) {

            // 如果该目录下有文件或文件夹，则循环
            if (files.length > 0) {
                for (File file:files) {
                    // 2、对遍历到的file对象判断是否是目录。
                    if (file.isDirectory()) {
                        // 如果是文件夹，则递归
                        removeDir(file);
                    } else {
                        System.out.println(file + " : " + file.delete());
                    }
                }
            }

            // 如果当前目录下没文件或文件夹、或已删除文件夹下文件，则直接删除目录
            System.out.println(dir + " : " + dir.delete());
        }

    }
}
