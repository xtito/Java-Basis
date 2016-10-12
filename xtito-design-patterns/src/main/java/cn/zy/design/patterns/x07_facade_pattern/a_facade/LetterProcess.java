package cn.zy.design.patterns.x07_facade_pattern.a_facade;

/**
 * 定义一个写信的过程
 * Created by [Zy]
 * 2016/10/11 17:17
 */
public interface LetterProcess {

    //首先要写信的内容
    void writeContext(String context);

    //其次写信封
    void fillEnvelope(String address);

    //把信放到信封里
    void letterInotoEnvelope();

    //然后邮递
    void sendLetter();

}
