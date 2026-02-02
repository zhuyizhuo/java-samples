package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

/**
 * Pow(x, n)
 *
 * 实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，x^n ）。
 */
public class Solution50 {
    /**
     * beats 100%
     */
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}