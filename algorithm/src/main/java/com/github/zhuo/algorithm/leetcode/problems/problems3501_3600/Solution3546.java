package com.github.zhuo.algorithm.leetcode.problems.problems3501_3600;

/**
 * 等和矩阵分割 I
 *
 * 给你一个由正整数组成的 m x n 矩阵 grid。你的任务是判断是否可以通过 一条水平或一条垂直分割线 将矩阵分割成两部分，使得：
 *
 * 分割后形成的每个部分都是 非空 的。
 * 两个部分中所有元素的和 相等 。
 * 如果存在这样的分割，返回 true；否则，返回 false。
 */
public class Solution3546 {

    /**
     * beats 100%
     */
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[] rows = new long[m];
        long[] cols = new long[n];
        long total = 0L;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
                cols[j] += grid[i][j];
            }
            rows[i] = total;
        }
        long sum = rows[m - 1];
        if (sum % 2 != 0) {
            return false;
        }
        sum = sum >> 1;
        for (long i : rows) {
            if (i == sum) {
                return true;
            }
        }
        total = 0L;
        for (long i : cols) {
            total += i;
            if (total == sum) {
                return true;
            }
        }
        return false;
    }
}