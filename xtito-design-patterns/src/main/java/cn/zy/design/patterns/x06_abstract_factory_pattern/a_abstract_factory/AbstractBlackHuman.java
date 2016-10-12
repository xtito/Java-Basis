package cn.zy.design.patterns.x06_abstract_factory_pattern.a_abstract_factory;

/**
 * 黑色人种，记得中学学英语，老师说black man是侮辱人的意思，不懂，没跟老外说话
 * Created by [Zy]
 * 2016/10/11 16:16
 */
public abstract class AbstractBlackHuman implements Human {

    public void cry() {
        System.out.println("黑人会哭");
    }

    public void laugh() {
        System.out.println("黑人会笑");
    }

    public void talk() {
        System.out.println("黑人可以说话，一般人听不懂");
    }
}
