package cn.zy.design.patterns.x06_abstract_factory_pattern.a_abstract_factory;

/**
 * Created by [Zy]
 * 2016/10/11 16:26
 */
public enum HumanEnum {

    //把世界上所有人类型都定义出来
    YelloMaleHuman("cn.zy.design.patterns.x06_abstract_factory_pattern.a_abstract_factory.YellowMaleHuman"),
    YelloFemaleHuman("cn.zy.design.patterns.x06_abstract_factory_pattern.a_abstract_factory.YellowFemaleHuman"),
    WhiteFemaleHuman("cn.zy.design.patterns.x06_abstract_factory_pattern.a_abstract_factory.WhiteFemaleHuman"),
    WhiteMaleHuman("cn.zy.design.patterns.x06_abstract_factory_pattern.a_abstract_factory.WhiteMaleHuman"),
    BlackFemaleHuman("cn.zy.design.patterns.x06_abstract_factory_pattern.a_abstract_factory.BlackFemaleHuman"),
    BlackMaleHuman("cn.zy.design.patterns.x06_abstract_factory_pattern.a_abstract_factory.BlackMaleHuman");

    private String value = "";

    //定义构造函数，目的是Data(value)类型的相匹配
    HumanEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

    /*
    * java enum类型尽量简单使用，尽量不要使用多态、继承等方法
    * 毕竟用Clas完全可以代替enum
    */

}
