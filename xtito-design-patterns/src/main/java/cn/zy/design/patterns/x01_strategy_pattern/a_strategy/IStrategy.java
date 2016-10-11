package cn.zy.design.patterns.x01_strategy_pattern.a_strategy;

/**
 * Created by [Zy]
 *
 * 首先定一个策略接口，这是诸葛亮老人家给赵云的三个锦囊妙计的接口
 * 2016/10/4 19:14
 */
public interface IStrategy {

    // 每个锦囊妙计都是一个可执行的算法
    void operate();

}
