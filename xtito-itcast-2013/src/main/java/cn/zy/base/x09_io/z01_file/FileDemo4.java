package cn.zy.base.x09_io.z01_file;

import cn.zy.base.x09_io.z01_file.filter.FilenameFilterBySuffix;

import java.io.File;

/**
 * 获取目录中的内容，但是只要.java文件。
 * Created by [Zy]
 * 2016/5/5 17:56
 */
public class FileDemo4 {

    public static void main(String[] args) {
        /*
		 * 需求2：获取目录中的内容，但是只要.java文件。
		 */
        File dir = new File("F:\\test");

        // 需要传递一个文件名过滤器 FilenameFilter对象。
        File[] files = dir.listFiles(new FilenameFilterBySuffix(".jpg"));

        /*
        // listFiles源码解析。
        // FilenameFilter filter = new FilenameFilterByJava()
		public File[] listFiles(FilenameFilter filter) {
	        String ss[] = list();//调用了File类中的list()获取到所有的名称数组 ss。
	        if (ss == null) return null;//健壮性判断，如果数组为null，就返回。
	        ArrayList<File> files = new ArrayList<>();//创建一个集合。元素是File类型。
	        for (String s : ss)//遍历名称数组。
	            if ((filter == null) || filter.accept(this, s))//对遍历的名称进行过滤器的判断。将 当前目录this，遍历到名称s传递给accept方法。
	            			//一旦条件满足过滤器的过滤条件。
	                files.add(new File(s, this));//将满足过滤条件添加到集合中。添加是 将文件名称和当前目录封装成File对象。new File(dir,name);

	        return files.toArray(new File[files.size()]);//将集合转成数组返回，为啥呢？不需要增删操作。
	    }
		*/

        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
