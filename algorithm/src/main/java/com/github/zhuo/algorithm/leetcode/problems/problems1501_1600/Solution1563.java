package com.github.zhuo.algorithm.leetcode.problems.problems1501_1600;

/**
 * 石子游戏 V
 * hard
 */
public class Solution1563 {
    /**
     * beats 99.76%
     */
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + stoneValue[i];
        }

        int[][] f = new int[n][n + 1];
        int[][] sufMax = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            sufMax[i + 1][i + 1] = Integer.MIN_VALUE;
            sufMax[i][i + 1] = -sum[i];

            int preMax = 0;
            int k = i + 1;
            for (int j = i + 2; j <= n; j++) {
                while (sum[k] - sum[i] <= sum[j] - sum[k]) {
                    preMax = Math.max(preMax, f[i][k] + sum[k]);
                    k++;
                }
                // 循环结束后 sum[k] - sum[i] > sum[j] - sum[k]
                int q = sum[k - 1] - sum[i] == sum[j] - sum[k - 1] ? k - 1 : k;
                f[i][j] = Math.max(preMax - sum[i], sufMax[q][j] + sum[j]);
                sufMax[i][j] = Math.max(sufMax[i + 1][j], f[i][j] - sum[i]);
            }
        }

        return f[0][n];
    }
}