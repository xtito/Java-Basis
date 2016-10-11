package cn.zy.design.patterns.x02_proxy_pattern.a_proxy;

/**
 * Created by [Zy]
 *
 * 王婆这个人老聪明了，她太老了，是个男人都看不上，
 * 但是她有智慧有经验呀，她作为一类女人的代理！
 * 2016/10/4 19:48
 */
public class WangPo implements KindWomen {

    private KindWomen kindWomen;

    public WangPo(){ //默认的话，是潘金莲的代理
        this.kindWomen = new PanJinLian();
    }

    // 她可以是KindWomen的任何一个女人的代理，只要你是这一类型
    public WangPo(KindWomen kindWomen){
        this.kindWomen = kindWomen;
    }

    public void happyWithMan() {
        // 自己老了，干不了，可以让年轻的代替
        this.kindWomen.happyWithMan();
    }

    public void makeEyesWithMan() {
        // 王婆这么大年龄了，谁看她抛媚眼？
        this.kindWomen.makeEyesWithMan();
    }
}
