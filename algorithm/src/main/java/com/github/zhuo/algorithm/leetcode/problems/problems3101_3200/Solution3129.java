package com.github.zhuo.algorithm.leetcode.problems.problems3101_3200;

/**
 * 找出所有稳定的二进制数组 I
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
public class Solution3129 {

    /**
     * beats 100%
     */
    public int numberOfStableArrays(int zero, int one, int limit) {
        final int mod = 1_000_000_007;
        int L = limit + 1;

        int[][] dp0 = new int[zero + 1][one + 1]; // i 0s + j 1s ending with 0
        int[][] dp1 = new int[zero + 1][one + 1]; // i 0s + j 1s ending with 1

        // Base cases: only zeros or only ones => only one string if len <= min(limit, zero/one)
        for (int i = 1; i <= Math.min(zero, limit); ++i) dp0[i][0] = 1;
        for (int j = 1; j <= Math.min(one, limit); ++j) dp1[0][j] = 1;

        // DP iterations
        for (int i = 1; i <= zero; ++i) {
            for (int j = 1; j <= one; ++j) {
                dp0[i][j] = (dp0[i - 1][j] + dp1[i - 1][j] - (i >= L ? dp1[i - L][j] : 0)) % mod;
                dp1[i][j] = (dp1[i][j - 1] + dp0[i][j - 1] - (j >= L ? dp0[i][j - L] : 0)) % mod;

                // Fix negatives
                dp0[i][j] = (dp0[i][j] + mod) % mod;
                dp1[i][j] = (dp1[i][j] + mod) % mod;
            }
        }

        return (dp0[zero][one] + dp1[zero][one]) % mod;
    }
}