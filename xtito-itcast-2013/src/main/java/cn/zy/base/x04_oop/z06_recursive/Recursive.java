package cn.zy.base.x04_oop.z06_recursive;

import java.util.Scanner;

/**
 * 递归
 * Created by [Zy]
 * 2016/3/1 22:44
 */
public class Recursive {

    public static void main(String[] args) {
        int i;
        System.out.println("请输入要求阶乘的一个整数:");
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        i = input.nextInt();
        System.out.println(i + "的阶乘结果是：" + fact(i));
    }

    static long fact(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

}
