package cn.zy.base.x10_gui.b;

import java.io.File;
import java.io.FileFilter;

/**
 * 文件夹过滤器
 *
 * Created by [Zy]
 * 2017/4/15 21:13
 */
public class DirectoryFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory();
    }
}
