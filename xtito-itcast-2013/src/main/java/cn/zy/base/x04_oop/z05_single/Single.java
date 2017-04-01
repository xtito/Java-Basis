package cn.zy.base.x04_oop.z05_single;

/**
 * 单例模式-懒汉式（线程安全）
 * Created by [Zy]
 * 2016/3/1 22:43
 */
public class Single {

    private static Single single = null;

    private Single() {}

    public static Single getInstance() {
        if (single == null) {
            synchronized (Single.class) {
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }


}
