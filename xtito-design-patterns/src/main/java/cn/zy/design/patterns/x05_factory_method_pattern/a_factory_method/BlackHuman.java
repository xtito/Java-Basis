package cn.zy.design.patterns.x05_factory_method_pattern.a_factory_method;

/**
 * Created by [Zy]
 *
 * 黑色人种，记得中学学英语，老师说black man是侮辱人的意思，不懂，没跟老外说话
 * 2016/10/4 20:20
 */
public class BlackHuman implements Human{

    public void laugh() {
        System.out.println("黑人会哭");
    }

    public void cry() {
        System.out.println("黑人会笑");
    }

    public void talk() {
        System.out.println("黑人可以说话，一般人听不懂");
    }
}
