package cn.zy.design.patterns.x05_factory_method_pattern.a_factory_method;

/**
 * Created by [Zy]
 *
 * 黄色人种，这个翻译的不准确，将就点吧
 * 2016/10/4 20:18
 */
public class YellowHuman implements Human {

    public void laugh() {
        System.out.println("黄色人种会哭");
    }

    public void cry() {
        System.out.println("黄色人种会大笑，幸福呀！");
    }

    public void talk() {
        System.out.println("黄色人种会说话，一般说的都是双字节");
    }
}
