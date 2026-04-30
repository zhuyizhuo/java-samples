package com.github.zhuo.algorithm.leetcode.problems.problems3201_3300;

/**
 * 网格图操作后的最大分数
 * hard
 *
 * 给你一个大小为 n x n 的二维矩阵 grid ，一开始所有格子都是白色的。一次操作中，你可以选择任意下标为 (i, j) 的格子，并将第 j 列中从最上面到第 i 行所有格子改成黑色。
 *
 * 如果格子 (i, j) 为白色，且左边或者右边的格子至少一个格子为黑色，那么我们将 grid[i][j] 加到最后网格图的总分中去。
 *
 * 请你返回执行任意次操作以后，最终网格图的 最大 总分数。
 */
public class Solution3225 {

    /**
     * beats 100%
     */
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        long res = 0, prev1 = 0, prev2 = 0;
        int i = 0;
        while (i < n - 1) {
            long curr = score(grid, dp1, i, prev1, 0, 1, n);
            prev1 = Math.max(res, prev2);
            prev2 = score(grid, dp2, i + 1, res, n - 1, -1, -1);
            res = Math.max(prev1, curr);
            i++;
        }
        return Math.max(res, prev2);
    }
    long score(int[][] grid, long[] dp, int col, long prev, int row, int dir, int stop) {
        long max = 0;
        while (row != stop) {
            max = Math.max(max, prev);
            prev = dp[row];
            max += grid[row][col];
            dp[row] = max;
            row += dir;
        }
        return max;
    }
}