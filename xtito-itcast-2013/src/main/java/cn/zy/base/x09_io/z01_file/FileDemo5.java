package cn.zy.base.x09_io.z01_file;

import cn.zy.base.x09_io.z01_file.filter.FileFilterByDir;

import java.io.File;

/**
 * Created by [Zy]
 * 2016/5/5 18:05
 */
public class FileDemo5 {

    public static void main(String[] args) {

        File dir = new File("F:\\test");

        File[] files = dir.listFiles(new FileFilterByDir());

        for(File file : files){
            System.out.println(file);
        }

    }
}
