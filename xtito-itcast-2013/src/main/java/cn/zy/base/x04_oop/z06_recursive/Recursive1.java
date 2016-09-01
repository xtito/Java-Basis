package cn.zy.base.x04_oop.z06_recursive;

/**
 * Created by [Zy]
 * 2016/3/1 22:44
 */
public class Recursive1 {

    public static void main(String[] args) {
        System.out.println(f(5));
    }

    public static int f(int n) {
        if (1 == n)
            return 1;
        else
            return n * f(n - 1);
    }

}
