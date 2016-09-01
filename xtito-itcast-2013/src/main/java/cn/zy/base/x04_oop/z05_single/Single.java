package cn.zy.base.x04_oop.z05_single;

/**
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
