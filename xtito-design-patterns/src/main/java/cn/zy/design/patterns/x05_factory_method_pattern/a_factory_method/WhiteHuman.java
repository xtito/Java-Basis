package cn.zy.design.patterns.x05_factory_method_pattern.a_factory_method;

/**
 * Created by [Zy]
 *
 * 白色人种
 * 2016/10/4 20:19
 */
public class WhiteHuman implements Human {

    public void laugh() {
        System.out.println("白色人种会哭");
    }

    public void cry() {
        System.out.println("白色人种会大笑，侵略的笑声");
    }

    public void talk() {
        System.out.println("白色人种会说话，一般都是但是单字节！");
    }
}
