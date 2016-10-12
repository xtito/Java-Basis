package cn.zy.design.patterns.x06_abstract_factory_pattern.a_abstract_factory;

/**
 * 白色人人种
 * 为了代码整洁，新建一个包，这里是白种人的天下了
 * Created by [Zy]
 * 2016/10/11 16:13
 */
public abstract class AbstractWhiteHuman implements Human {

    public void cry() {
        System.out.println("白色人种会哭");
    }

    public void laugh() {
        System.out.println("白色人种会大笑，侵略的笑声");
    }

    public void talk() {
        System.out.println("白色人种会说话，一般都是但是单字节！");
    }

}
