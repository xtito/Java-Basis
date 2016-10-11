package cn.zy.design.patterns.x02_proxy_pattern.a_proxy;

/**
 * Created by [Zy]
 *
 * 定一个潘金莲是什么样的人
 * 2016/10/4 19:47
 */
public class PanJinLian implements KindWomen {

    public void happyWithMan() {
        System.out.println("潘金莲在和男人做那个.....");
    }

    public void makeEyesWithMan() {
        System.out.println("潘金莲抛媚眼");
    }
}
