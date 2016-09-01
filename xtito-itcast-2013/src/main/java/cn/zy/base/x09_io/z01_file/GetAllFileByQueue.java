package cn.zy.base.x09_io.z01_file;

import java.io.File;
import java.util.LinkedList;

/**
 * 不用递归遍历目录
 * Created by [Zy]
 * 2016/5/6 9:51
 */
public class GetAllFileByQueue {

    public static void main(String[] args) {
        /*
         * 遍历文件夹，不用递归咋办？
		 * 思路：
		 * 1，可以通过对每一个目录进行for循环，但是目录层级很多，for会死掉。
		 * 2，每遍历到一个目录，不对其进行遍历，而是先临时存储起来。 相当于把所有目录（无论同级不同级）都存储起来。
		 * 3，遍历容器时取到就是目录，然后对目录遍历即可。
		 * 4，从容器中取到目录遍历时发现内部还有目录，一样将这些目录存储到容器中。
		 * 5，只要不断的遍历这个容器就哦了。
		 *
		 * 通过图解：发现这个容器只要是一个简单的队列就可以解决这个问题。
		 */
        File dir = new File("F:/test");
        Queue<File> queue = new Queue<File>();

        // 1,对dir进行当前目录的遍历。
        File[] files = dir.listFiles();

        if (files != null && files.length > 0) {
            for (File file : files) {
                // 2, 如果有子目录，存储到队列中。
                if (file.isDirectory()) {
                    queue.myAdd(file);
                } else {
                    System.out.println(file.getName());
                }
            }

            System.out.println("-------------------");

            // 3,遍历队列容器。因为子目录都在队列中。
            while (!queue.isNull()) {
                // 从队列中取出子目录。
                File subDir = queue.myGet();

                System.out.println(subDir.getName());

                // 4,遍历子目录。
                File[] subFiles = subDir.listFiles();

                if (subFiles != null && subFiles.length > 0) {
                    for (File subFile : subFiles) {

                        // 如果子目录中还有子目录，继续存储到队列中。
                        if (subFile.isDirectory()) {
                            queue.myAdd(subFile);
                        } else {
                            System.out.println(subFile.getName());
                        }
                    }
                }
            }
        }

    }


}


/**
 * 队列结构。先进先出。
 */
class Queue<E> {

    private LinkedList<E> link;

    /**
     * 提供了构造队列对象的构造器。
     */
    public Queue() {
        link = new LinkedList<E>();
    }

    /**
     * 添加元素的方法。
     */
    public void myAdd(E obj) {
        link.addFirst(obj);
    }

    /**
     * 获取的方法。
     */
    public E myGet() {
        return link.removeFirst();
    }

    /**
     * 判断队列是否有元素。
     */
    public boolean isNull() {
        return link.isEmpty();
    }

}
