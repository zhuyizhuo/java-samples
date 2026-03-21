package com.github.zhuo.algorithm.leetcode.problems.problems3501_3600;

/**
 *
 * 垂直翻转子矩阵
 * easy
 *
 * 给你一个 m x n 的整数矩阵 grid，以及三个整数 x、y 和 k。
 *
 * 整数 x 和 y 表示一个 正方形子矩阵 的左上角下标，整数 k 表示该正方形子矩阵的边长。
 *
 * 你的任务是垂直翻转子矩阵的行顺序。
 *
 * 返回更新后的矩阵。
 */
public class Solution3643 {
    /**
     * beats 100%
     */
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i0 = x, i1 = x + k - 1; i0 < i1; i0++, i1--) {
            for (int j = y; j < y + k; j++) {
                int temp = grid[i0][j];
                grid[i0][j] = grid[i1][j];
                grid[i1][j] = temp;
            }
        }
        return grid;
    }
}