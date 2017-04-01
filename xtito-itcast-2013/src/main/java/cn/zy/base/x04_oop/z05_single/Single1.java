package cn.zy.base.x04_oop.z05_single;

/**
 * 单例模式-饿汉式（线程安全）
 * Created by [Zy]
 * 2016/3/1 22:43
 */
public class Single1 {

    private static final Single1 single = new Single1();

    private Single1() {}

    public static Single1 getInstance() {
        return single;
    }


}
