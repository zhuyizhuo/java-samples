package com.github.zhuo.algorithm.leetcode.problems.problems701_800;

/**
 * 二进制表示中质数个计算置位
 * easy
 *
 * 给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
 *
 * 计算置位位数 就是二进制表示中 1 的个数。
 *
 * 例如， 21 的二进制表示 10101 有 3 个计算置位。
 */
public class Solution762 {
    /**
     * beats 87%
     */
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for (int x = left; x <= right; ++x) {
            if (isPrime(Integer.bitCount(x))) {
                ++ans;
            }
        }
        return ans;
    }

    private boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i * i <= x; ++i) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
