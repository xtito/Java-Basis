package cn.zy.design.patterns.x06_abstract_factory_pattern.a_abstract_factory;

/**
 * 女性白种人
 * Created by [Zy]
 * 2016/10/11 16:21
 */
public class WhiteFemaleHuman extends AbstractWhiteHuman {

    @Override
    public void sex() {
        System.out.println("该白种人的性别为女....");
    }
}
