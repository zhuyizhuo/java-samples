package com.github.zhuo.algorithm.leetcode.problems.problems3101_3200;

/**
 * 找出所有稳定的二进制数组 II
 * hard
 *
 * 给你 3 个正整数 zero ，one 和 limit 。
 *
 * 一个 二进制数组 arr 如果满足以下条件，那么我们称它是 稳定的 ：
 *
 * 0 在 arr 中出现次数 恰好 为 zero 。
 * 1 在 arr 中出现次数 恰好 为 one 。
 * arr 中每个长度超过 limit 的 子数组 都 同时 包含 0 和 1 。
 * 请你返回 稳定 二进制数组的 总 数目。
 *
 * 由于答案可能很大，将它对 10^9 + 7 取余 后返回。
 */
public class Solution3130 {

    private static final int MOD = 1_000_000_007;
    private static final int MX = 1001;

    private static final long[] F = new long[MX]; // f[i] = i!
    private static final long[] INV_F = new long[MX]; // inv_f[i] = i!^-1

    static {
        F[0] = 1;
        for (int i = 1; i < MX; i++) {
            F[i] = F[i - 1] * i % MOD;
        }

        INV_F[MX - 1] = pow(F[MX - 1], MOD - 2);
        for (int i = MX - 1; i > 0; i--) {
            INV_F[i - 1] = INV_F[i] * i % MOD;
        }
    }

    /**
     * beats 100%
     */
    public int numberOfStableArrays(int zero, int one, int limit) {
        if (zero > one) {
            // swap，保证空间复杂度为 O(min(zero, one))
            int t = zero;
            zero = one;
            one = t;
        }
        long[] f0 = new long[zero + 3];
        for (int i = (zero - 1) / limit + 1; i <= zero; i++) {
            f0[i] = comb(zero - 1, i - 1);
            for (int j = 1; j <= (zero - i) / limit; j++) {
                f0[i] = (f0[i] + (1 - j % 2 * 2) * comb(i, j) * comb(zero - j * limit - 1, i - 1)) % MOD;
            }
        }

        long ans = 0;
        for (int i = (one - 1) / limit + 1; i <= Math.min(one, zero + 1); i++) {
            long f1 = comb(one - 1, i - 1);
            for (int j = 1; j <= (one - i) / limit; j++) {
                f1 = (f1 + (1 - j % 2 * 2) * comb(i, j) * comb(one - j * limit - 1, i - 1)) % MOD;
            }
            ans = (ans + (f0[i - 1] + f0[i] * 2 + f0[i + 1]) * f1) % MOD;
        }
        return (int) ((ans + MOD) % MOD); // 保证结果非负
    }

    private long comb(int n, int m) {
        return F[n] * INV_F[m] % MOD * INV_F[n - m] % MOD;
    }

    private static long pow(long x, int n) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
        }
        return res;
    }
}