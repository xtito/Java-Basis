package cn.zy.design.patterns.x06_abstract_factory_pattern.a_abstract_factory;

/**
 * 男性黑种人
 * Created by [Zy]
 * 2016/10/11 16:24
 */
public class BlackMaleHuman extends AbstractBlackHuman {


    @Override
    public void sex() {
        System.out.println("该黑种人的性别为男...");
    }
}
