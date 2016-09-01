package cn.zy.base.x09_io.z01_file.filter;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 用于过滤指定扩展名的文件。
 * Created by [Zy]
 * 2016/5/5 17:58
 */
public class FilenameFilterBySuffix implements FilenameFilter {

    private String suffix;

    public FilenameFilterBySuffix(String suffix) {
        super();
        this.suffix = suffix;
    }

    @Override
    public boolean accept(File dir, String name) {


        return name.endsWith(suffix);
    }

}
