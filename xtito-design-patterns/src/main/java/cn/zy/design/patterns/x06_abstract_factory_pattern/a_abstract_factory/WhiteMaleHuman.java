package cn.zy.design.patterns.x06_abstract_factory_pattern.a_abstract_factory;

/**
 * 男性白种人
 * Created by [Zy]
 * 2016/10/11 16:22
 */
public class WhiteMaleHuman extends AbstractWhiteHuman {


    @Override
    public void sex() {
        System.out.println("该白种人的性别为男....");
    }
}
