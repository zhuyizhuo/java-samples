package com.github.zhuo.algorithm.leetcode.problems.problems1101_1200;

import java.util.Arrays;

/**
 * 石子游戏 II
 */
public class Solution1140 {

    /**
     * beats 100%
     */
    public int stoneGameII(int[] piles) {
        int[] s = piles;
        int n = s.length;
        for (int i = n - 2; i >= 0; i--) {
            s[i] += s[i + 1]; // 后缀和
        }

        int[][] memo = new int[n - 1][(n + 1) / 4 + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(0, 1, s, memo);
    }

    private int dfs(int i, int m, int[] s, int[][] memo) {
        if (i + m * 2 >= s.length) {
            return s[i]; // 全拿
        }
        if (memo[i][m] != -1) { // 之前计算过
            return memo[i][m];
        }
        int mn = Integer.MAX_VALUE;
        for (int x = 1; x <= m * 2; x++) {
            mn = Math.min(mn, dfs(i + x, Math.max(m, x), s, memo));
        }
        return memo[i][m] = s[i] - mn; // 记忆化
    }
}