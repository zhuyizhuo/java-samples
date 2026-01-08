package com.github.zhuo.algorithm.leetcode.problems.problems3401_3500;

/**
 * 给你一个由 非负 整数组成的 m x n 矩阵 grid。
 *
 * 在一次操作中，你可以将任意元素 grid[i][j] 的值增加 1。
 *
 * 返回使 grid 的所有列 严格递增 所需的 最少 操作次数。
 *
 * 提示:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 0 <= grid[i][j] < 2500
 */
public class Solution3402 {

    /**
     * 1ms beats 100%
     */
    public int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] <= grid[i - 1][j]) {
                    ans += grid[i - 1][j] + 1 - grid[i][j];
                    grid[i][j] = grid[i - 1][j] + 1;
                }
            }
        }
        return ans;
    }
}
