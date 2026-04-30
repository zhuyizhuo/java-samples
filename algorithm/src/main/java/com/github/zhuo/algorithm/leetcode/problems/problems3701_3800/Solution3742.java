package com.github.zhuo.algorithm.leetcode.problems.problems3701_3800;

import java.util.Arrays;

/**
 * 网格中得分最大的路径
 *
 * 给你一个 m x n 的网格 grid，其中每个单元格包含以下值之一：0、1 或 2。另给你一个整数 k。
 *
 * 你从左上角 (0, 0) 出发，目标是到达右下角 (m - 1, n - 1)，只能向 右 或 下 移动。
 *
 * 每个单元格根据其值对路径有以下贡献：
 *
 * 值为 0 的单元格：分数增加 0，花费 0。
 * 值为 1 的单元格：分数增加 1，花费 1。
 * 值为 2 的单元格：分数增加 2，花费 1。
 * 返回在总花费不超过 k 的情况下可以获得的 最大分数 ，如果不存在有效路径，则返回 -1。
 *
 * 注意： 如果到达最后一个单元格时总花费超过 k，则该路径无效。
 */
public class Solution3742 {

    /**
     * beats 99.46%
     */
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        // 从左上角到右下角，且 grid[0][0] == 0，非0单元格个数最多为m+n-2
        k = Math.min(k, m + n - 2);
        // dp[i+1][j+1][cost]:到达(i,j)且花费恰好为cost时，最大得分
        int[][] dp = new int[n + 1][k + 1];
        // 只能从左上角出发
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE / 2);
        }
        dp[1][0] = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                // 到达(i,j)经过非零单元格最多为i+j+1
                // 由于第k项依赖第k-1项，空间优化后避免覆盖，倒序遍历
                for (int cost = Math.min(i + j + 1, k); cost >= 0; cost--) {
                    if (val == 0) {
                        dp[j + 1][cost] = Math.max(dp[j][cost], dp[j + 1][cost]);
                    } else if (cost > 0) {
                        dp[j + 1][cost] = val + Math.max(dp[j][cost - 1], dp[j + 1][cost - 1]);
                    } else {
                        dp[j + 1][cost] = Integer.MIN_VALUE / 2;
                    }
                }
            }
        }
        int res = -1;
        for (int score : dp[n]) {
            res = Math.max(res, score);
        }
        return res;
    }
}