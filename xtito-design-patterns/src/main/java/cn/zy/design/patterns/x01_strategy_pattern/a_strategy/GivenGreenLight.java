package cn.zy.design.patterns.x01_strategy_pattern.a_strategy;

/**
 * Created by [Zy]
 *
 * 求吴国太开个绿灯
 * 2016/10/4 19:18
 */
public class GivenGreenLight implements IStrategy {

    public void operate() {
        System.out.println("求吴国太开个绿灯,放行！");
    }
}
