package cn.zy.base.x09_io.z01_file.test;

import cn.zy.base.utils.constant.SeparatorConstant;
import cn.zy.base.utils.filter.FileFilterBySuffix;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取指定目录下所有的.java文件(包含子目录中的)，
 * 并将这些java文件的绝路路径写入到一个文件中。
 * 建立一个java文件清单列表。
 * Created by [Zy]
 * 2016/6/30 13:37
 */
public class C_Test3 {

    public static void main(String[] args) {

        /**
		 * 思路：
		 * 1，一看到包含子目录，必须递归。
		 * 2，写数据到文件，输出流。
		 * 3，继续分析，发现只要.java ，需要过滤器。
		 * 4，满足过滤的条件的文件有可能非常多，先进行存储。
		 */
        Long startDate = System.currentTimeMillis();

        // 被遍历的目录。
        File dir = new File("F:\\Java学习视频\\Java-黑马\\Java基础");

        // 明确一个过滤器。
        FileFilterBySuffix filter = new FileFilterBySuffix(".txt");

        // 符合过滤器条件的文件有很多，最好先存储起来，然后在进行操作。
        List<File> list = new ArrayList<File>();
        // 获取指定文件清单。
        getFileList(dir, filter, list);

        System.out.println(list.size());

        File destFile = new File("F:\\test\\javaList.text");
        write2File(list, destFile);

        Long endDate = System.currentTimeMillis();

        System.out.println(endDate - startDate + "ms");
    }


    /**
     * 将集合中的数据的绝对路径写入到文件中。
     * @param list 要写出的集合
     * @param destFile 写出目的文件
     */
    private static void write2File(List<File> list, File destFile) {

        FileOutputStream fos = null;
        BufferedOutputStream buFos = null;
        try {

            fos = new FileOutputStream(destFile);
            buFos = new BufferedOutputStream(fos);

            if (list.size() > 0) {
                for (File file:list) {
                    String info = file.getAbsolutePath() + SeparatorConstant.LINE_SEPARATOR;
                    buFos.write(info.getBytes());
                    // 每写一个绝对路径就刷新一次。
                    buFos.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buFos != null) {
                try {
                    buFos.close();
                } catch (IOException e) {
                    throw new RuntimeException("系统资源关闭失败");
                }
            }
        }

    }


    /**
     * 根据指定的过滤器在指定目录下获取所有的符合过滤条件的文件，并存储到list集合中。
     * @param dir 要遍历的目录
     * @param filter 文件过滤器
     * @param list 符合条件后存储的集合
     */
    private static void getFileList(File dir, FileFilterBySuffix filter, List<File> list) {

        File[] files = dir.listFiles();

        // 如果遍历的不是系统盘，不为NULL，并且有子级
        if (files != null && files.length > 0) {
            for (File file:files) {
                if (file.isDirectory()) {
                    getFileList(file, filter, list);
                } else {
                    // 如果是文件，传递到过滤器中去过滤。将满足条件存储起来。
                    if (filter.accept(file)) {
                        list.add(file);
                    }
                }
            }
        }

    }
}
