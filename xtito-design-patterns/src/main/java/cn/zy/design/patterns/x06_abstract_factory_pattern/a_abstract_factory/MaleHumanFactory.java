package cn.zy.design.patterns.x06_abstract_factory_pattern.a_abstract_factory;

/**
 * 男性创建工厂
 * Created by [Zy]
 * 2016/10/11 16:35
 */
public class MaleHumanFactory extends AbstractHumanFactory {

    // 创建一个男性黑种人
    public Human createBlackHuman() {
        return super.createHuman(HumanEnum.BlackMaleHuman);
    }

    // 创建一个男性白种人
    public Human createWhiteHuman() {
        return super.createHuman(HumanEnum.WhiteMaleHuman);
    }

    // 创建一个男性黄种人
    public Human createYellowHuman() {
        return super.createHuman(HumanEnum.YelloMaleHuman);
    }

}
