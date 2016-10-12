package cn.zy.design.patterns.x06_abstract_factory_pattern.a_abstract_factory;

/**
 * 这次定一个接口，应该要造不同性别的人，需要不同的生产线
 * 那这个八卦炉必须可以制造男人和女人
 * Created by [Zy]
 * 2016/10/11 16:31
 */
public interface HumanFactory {

    //制造黄色人种
    Human createYellowHuman();

    //制造一个白色人种
    Human createWhiteHuman();

    //制造一个黑色人种
    Human createBlackHuman();

}
