package cn.zy.base.x09_io.z01_file.filter;

import java.io.File;
import java.io.FileFilter;

/**
 * 过滤文件加的过滤器。
 * Created by [Zy]
 * 2016/5/5 17:58
 */
public class FileFilterByDir implements FileFilter {

	@Override
	public boolean accept(File pathname) {
	
		return pathname.isDirectory();
	}

}
