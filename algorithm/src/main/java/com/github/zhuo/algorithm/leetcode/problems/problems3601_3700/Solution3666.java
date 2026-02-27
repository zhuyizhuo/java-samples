package com.github.zhuo.algorithm.leetcode.problems.problems3601_3700;

/**
 * 使二进制字符串全为 1 的最少操作次数
 * hard
 *
 * 给你一个二进制字符串 s 和一个整数 k。
 *
 * 在一次操作中，你必须选择 恰好 k 个 不同的 下标，并将每个 '0' 翻转 为 '1'，每个 '1' 翻转为 '0'。
 *
 * 返回使字符串中所有字符都等于 '1' 所需的 最少 操作次数。如果不可能，则返回 -1。
 */
public class Solution3666 {

    /**
     * beats 100%
     */
    public int minOperations(String s, int k) {
        int n = s.length();
        int z = 0;
        for (int i = 0; i < n; i++) {
            z += 1 - (s.charAt(i) - '0');
        }

        if (z == 0) {
            return 0;
        }
        if (k == n) {
            return z == n ? 1 : -1;
        }

        int ans = Integer.MAX_VALUE;
        // 情况一：操作次数 m 是偶数
        if (z % 2 == 0) { // z 必须是偶数
            int m = Math.max((z + k - 1) / k, (z + n - k - 1) / (n - k)); // 下界
            ans = m + m % 2; // 把 m 往上调整为偶数
        }

        // 情况二：操作次数 m 是奇数
        if (z % 2 == k % 2) { // z 和 k 的奇偶性必须相同
            int m = Math.max((z + k - 1) / k, (n - z + n - k - 1) / (n - k)); // 下界
            ans = Math.min(ans, m | 1); // 把 m 往上调整为奇数
        }

        return ans < Integer.MAX_VALUE ? ans : -1;
    }
}