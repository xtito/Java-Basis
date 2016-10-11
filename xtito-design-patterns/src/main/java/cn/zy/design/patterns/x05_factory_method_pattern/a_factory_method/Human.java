package cn.zy.design.patterns.x05_factory_method_pattern.a_factory_method;

/**
 * Created by [Zy]
 *
 * 定义一个人类的统称
 * 2016/10/4 20:18
 */
public interface Human {

    // 首先定义什么是人类

    // 人是愉快的，会笑的，本来是想用smile表示，想了一下laugh更合适，好长时间没有大笑了；
    void laugh();

    //人类还会哭，代表痛苦
    void cry();

    //人类会说话
    void talk();
}
