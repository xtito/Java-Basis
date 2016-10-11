package cn.zy.design.patterns.x01_strategy_pattern.a_strategy;

/**
 * Created by [Zy]
 *
 * 找乔国老帮忙，使孙权不能杀刘备
 * 2016/10/4 19:17
 */
public class BackDoor implements IStrategy {

    public void operate() {
        System.out.println("找乔国老帮忙，让吴国太给孙权施加压力");
    }
}
