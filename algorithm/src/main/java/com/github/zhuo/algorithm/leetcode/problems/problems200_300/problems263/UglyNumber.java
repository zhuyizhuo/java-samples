package com.github.zhuo.algorithm.leetcode.problems.problems200_300.problems263;

/**
 * https://leetcode-cn.com/problems/ugly-number/
 * 丑数
 * 难度 简单
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 * 提示：
 *   -2^31 <= n <= 2^31 - 1
 */
public class UglyNumber {

    public static void main(String[] args) {
//        System.out.println(isUgly(6));
//        System.out.println(isUgly(8));
//        System.out.println(isUgly(14));
//        System.out.println(isUgly(1));
        System.out.println(isUgly(0));
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 35.3 MB , 在所有 Java 提交中击败了 88.31% 的用户
     */
    public static boolean isUgly(int n) {
        if (n == 0){
            return false;
        }
        while (n%2==0){
            n = n/2;
        }
        while (n%3==0){
            n = n/3;
        }
        while (n%5==0){
            n = n/5;
        }
        return n==1;
    }

}
