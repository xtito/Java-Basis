package cn.zy.base.x09_io.z01_file.filter;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by [Zy]
 * 2016/5/5 17:58
 */
public class FilenameFilterByJava implements FilenameFilter {

	@Override
	public boolean accept(File dir, String name) {
		
//		System.out.println(dir+"::::"+name);
		return name.endsWith(".java");
	}

}
