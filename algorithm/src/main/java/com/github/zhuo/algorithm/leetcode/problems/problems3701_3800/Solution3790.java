package com.github.zhuo.algorithm.leetcode.problems.problems3701_3800;

/**
 * 给你一个正整数 k。
 *
 * 找出满足以下条件的 最小 整数 n：n 能被 k 整除，且其十进制表示中 只包含数字 1（例如：1、11、111、……）。
 *
 * 返回一个整数，表示 n 的十进制表示的 位数 。如果不存在这样的 n，则返回 -1。
 */
public class Solution3790 {
    /**
     * 2ms beats 100%
     */
    public int minAllOneMultiple(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        int m = phi(k * 9);

        // 从小到大枚举不超过 sqrt(m) 的因子
        int i = 1;
        for (; i * i <= m; i++) {
            if (m % i == 0 && pow(10, i, k * 9) == 1) {
                return i;
            }
        }

        // 从小到大枚举不低于 sqrt(m) 的因子
        for (i--; ; i--) {
            if (m % i == 0 && pow(10, m / i, k * 9) == 1) {
                return m / i;
            }
        }
    }

    // 计算欧拉函数（n 以内的与 n 互质的数的个数）
    private int phi(int n) {
        int res = n;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                res = res / i * (i - 1);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) {
            res = res / n * (n - 1);
        }
        return res;
    }

    // 快速幂，返回 pow(x, n) % mod
    private long pow(long x, int n, long mod) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                res = res * x % mod;
            }
            x = x * x % mod;
        }
        return res;
    }
}
