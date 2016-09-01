package cn.zy.base.x09_io.z01_file.test;

import cn.zy.base.bean.Student;
import cn.zy.base.utils.constant.SeparatorConstant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * 将学生对象(姓名，语文分数，数学分数，英语分数，总分)按照总分从高到低排序，
 * 并将姓名和从高到低总分写入文件中。
 * Created by [Zy]
 * 2016/6/30 13:11
 */
public class B_Test2 {

    public static void main(String[] args) {

        /**
		 * 思路：
		 * 1、描述学生。
		 * 2、既然要按照总分从高到低排序，学生多要存储集合，TreeSet。
		 * 3、将信息具体的信息保存到文件中。
		 * 		操作文件,持久化存储，涉及了IO技术。而且是将数据存储到文件中。所以写入。输出流。
		 */

        Set<Student> set = new TreeSet<Student>(Collections.reverseOrder());

        set.add(new Student("李四",20,20,20));
        set.add(new Student("旺财",10,10,20));
        set.add(new Student("小明",60,30,70));
        set.add(new Student("小红",80,90,80));
        set.add(new Student("小强",20,70,20));

        File dir = new File("F:\\test\\ac");
        if (!dir.exists()) {
            boolean dirCreateOk = dir.mkdir();
        }


        File destFile = new File(dir, "student_info.txt");
        writer2File(set, destFile);
    }


    private static void writer2File(Set<Student> set, File destFile) {

        // 1、创建输出流对象和目的文件关联。并创建目的文件。OutputStream操作文件 FileOutputStream。
        FileOutputStream fos = null;
        try {

            fos = new FileOutputStream(destFile);

            // 2、遍历集合中的对象数据。将数据写入到指定文件中。
            for (Student stu:set) {
                String info = stu.getName() + "\t" + stu.getSum() + SeparatorConstant.LINE_SEPARATOR;
                // 3、将数据写入到文件中。
                fos.write(info.getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            if (fos != null) {
                try {
                    // 关闭输出流资源
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException("系统资源关闭失败");
                }
            }
        }

    }
}
