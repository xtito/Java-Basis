package cn.zy.design.patterns.x06_abstract_factory_pattern.a_abstract_factory;

/**
 * 为什么要修改成抽象类呢？要定义性别呀
 * Created by [Zy]
 * 2016/10/11 16:11
 */
public abstract class AbstractYellowHuman implements Human {

    public void cry() {
        System.out.println("黄色人种会哭");
    }

    public void laugh() {
        System.out.println("黄色人种会大笑，幸福呀！");
    }

    public void talk() {
        System.out.println("黄色人种会说话，一般说的都是双字节");
    }

}
