package cn.zy.design.patterns.x01_strategy_pattern.a_strategy;

/**
 * Created by [Zy]
 *
 * 孙夫人断后，挡住追兵
 * 2016/10/4 19:19
 */
public class BlockEnemy implements IStrategy {


    public void operate() {
        System.out.println("孙夫人断后，挡住追兵");
    }
}
