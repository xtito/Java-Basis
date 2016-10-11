package cn.zy.design.patterns.x04_multition_pattern.a_multition;

/**
 * Created by [Zy]
 * <p/>
 * 大臣们悲惨了，一个皇帝都伺候不过来了，现在还来了两个个皇帝
 * TND，不管了，找到个皇帝，磕头，请按就成了！
 * 2016/10/4 20:15
 */
public class Minister {

    public static void main(String[] args) {
        int ministerNum = 10; // 10个大臣
        for (int i = 0; i < ministerNum; i++) {
            Emperor emperor = Emperor.getInstance();
            System.out.print("第" + (i + 1) + "个大臣参拜的是：");
            emperor.emperorInfo();
        }
    }
}
