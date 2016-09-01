package cn.zy.base.utils.constant;

/**
 * 为了避免总是调用System.getProperties("系统属性中的指定键");
 * 进行了封装。下次再使用分隔符，直接找个分隔符工具类就哦了。
 * Created by [Zy]
 * 2016/6/30 13:03
 */
public class SeparatorConstant {

    private SeparatorConstant() {
    }


    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    public static final String PATH_SEPARATOR = System.getProperty("path.separator");
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");

}
