package com.github.zhuo.algorithm.other;

public class SwitchAB {
    public static void main(String[] args) {
        int a = 900;
        int b = 2;
        a -= b;
        b += a;
        a = b - a;
        System.out.println(a);
        System.out.println(b);
    }
}
