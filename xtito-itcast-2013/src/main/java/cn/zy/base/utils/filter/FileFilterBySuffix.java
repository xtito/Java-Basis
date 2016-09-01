package cn.zy.base.utils.filter;

import java.io.File;
import java.io.FileFilter;

/**
 * 文件名过滤器
 * Created by [Zy]
 * 2016/6/30 13:09
 */
public class FileFilterBySuffix implements FileFilter {

    private String suffix;

    public FileFilterBySuffix(String suffix) {
        super();
        this.suffix = suffix;
    }

    @Override
    public boolean accept(File pathname) {

        return pathname.getName().endsWith(suffix);
    }
}
