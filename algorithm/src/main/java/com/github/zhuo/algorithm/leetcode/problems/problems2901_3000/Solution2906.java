package com.github.zhuo.algorithm.leetcode.problems.problems2901_3000;

/**
 * 构造乘积矩阵
 *
 * 给你一个下标从 0 开始、大小为 n * m 的二维整数矩阵 grid ，定义一个下标从 0 开始、大小为 n * m 的的二维矩阵 p。如果满足以下条件，则称 p 为 grid 的 乘积矩阵 ：
 *
 * 对于每个元素 p[i][j] ，它的值等于除了 grid[i][j] 外所有元素的乘积。乘积对 12345 取余数。
 * 返回 grid 的乘积矩阵。
 */
public class Solution2906 {

    /**
     * beats 100%
     */
    public int[][] constructProductMatrix(int[][] grid) {
        final int MOD = 12345;
        int n = grid.length, m = grid[0].length;
        int[][] p = new int[n][m];

        long suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                p[i][j] = (int)suffix;
                suffix = suffix * grid[i][j] % MOD;
            }
        }

        long prefix = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[i][j] = (int)((long)p[i][j] * prefix % MOD);
                prefix = prefix * grid[i][j] % MOD;
            }
        }

        return p;
    }
}