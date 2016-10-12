package cn.zy.design.patterns.x06_abstract_factory_pattern.a_abstract_factory;

/**
 * 女性创建工厂
 * Created by [Zy]
 * 2016/10/11 16:36
 */
public class FemaleHumanFactory extends AbstractHumanFactory {

    // 创建一个女性黑种人
    public Human createBlackHuman() {
        return super.createHuman(HumanEnum.BlackFemaleHuman);
    }

    // 创建一个女性白种人
    public Human createWhiteHuman() {
        return super.createHuman(HumanEnum.WhiteFemaleHuman);
    }

    // 创建一个女性黄种人
    public Human createYellowHuman() {
        return super.createHuman(HumanEnum.YelloFemaleHuman);
    }

}
