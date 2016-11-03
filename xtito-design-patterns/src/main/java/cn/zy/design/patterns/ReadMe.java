package cn.zy.design.patterns;

/**
 * Created by [Zy]
 * 2016/10/4 18:24
 */
public class ReadMe {
    /*
    x01_策略模式【strategy pattern】
    x02_代理模式【proxy pattern】
    x03_单例模式【singleton pattern】
    x04_多例模式【multition pattern】
    x05_工厂方法模式【factory method pattern】
    x06_抽象工厂模式【abstract factory pattern】
    x07_门面模式【facade pattern】
    x08_适配器模式【adapter pattern】
    x09_模板方法模式【template method pattern】
    x10_建造者模式【builder pattern】
    x11_桥梁模式【bridge pattern】
    x12_命令模式【command pattern】
    x13_装饰模式【decorator pattern】
    x14_迭代器模式【iterator pattern】
    x15_组合模式【composite pattern】
    x16_观察者模式【observer pattern】
    x17_责任链模式【chain of responsibility pattern】
    x18_访问者模式【visitor pattern】
    x19_状态模式【state pattern】
    x20_原型模式【prototype pattern】
    x21_中介者模式【mediator pattern】
    x22_解释器模式【interpreter pattern】
    x23_亨元模式【flyweight pattern】
    x24_备忘录模式【memento pattern】
     */

    public static void main(String[] args) {
        int[] a = {10,20,30,60};
        System.out.println(a(a, 4));
    }

    public static int a(int[] a, int n) {
        if (n > 0) {
            return a[n] + a(a, n-1);
        } else {
            return a[n];
        }
    }
}
