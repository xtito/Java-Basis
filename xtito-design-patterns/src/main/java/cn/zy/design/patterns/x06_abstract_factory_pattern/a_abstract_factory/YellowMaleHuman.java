package cn.zy.design.patterns.x06_abstract_factory_pattern.a_abstract_factory;

/**
 * Created by [Zy]
 * 2016/10/11 16:18
 */
public class YellowMaleHuman extends AbstractYellowHuman {

    @Override
    public void sex() {
        System.out.println("该黄种人的性别为男....");
    }
}
