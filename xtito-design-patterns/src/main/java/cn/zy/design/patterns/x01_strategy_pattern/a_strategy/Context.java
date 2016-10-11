package cn.zy.design.patterns.x01_strategy_pattern.a_strategy;

/**
 * Created by [Zy]
 *
 * 计谋有了，那还要有锦囊
 * 2016/10/4 19:20
 */
public class Context {

    // 构造函数，你要使用那个妙计
    private IStrategy straegy;
    public Context(IStrategy strategy){
        this.straegy = strategy;
    }

    // 使用计谋了，看我出招了
    public void operate(){
        this.straegy.operate();
    }
}
