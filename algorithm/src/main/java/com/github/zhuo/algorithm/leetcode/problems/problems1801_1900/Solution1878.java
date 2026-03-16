package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900;

import java.util.Arrays;

/**
 * 矩阵中最大的三个菱形和
 *
 * 给你一个 m x n 的整数矩阵 grid 。
 *
 * 菱形和 指的是 grid 中一个正菱形 边界 上的元素之和。本题中的菱形必须为正方形旋转45度，且四个角都在一个格子当中。
 * 下图是四个可行的菱形，每个菱形和应该包含的格子都用了相应颜色标注在图中。
 *
 * 注意，菱形可以是一个面积为 0 的区域，如上图中右下角的紫色菱形所示。
 *
 * 请你按照 降序 返回 grid 中三个最大的 互不相同的菱形和 。如果不同的和少于三个，则将它们全部返回。
 */
public class Solution1878 {

    private int x, y, z; // 最大，次大，第三大

    /**
     * beats 100%
     */
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] diagSum = new int[m + 1][n + 1]; // ↘ 前缀和
        int[][] antiSum = new int[m + 1][n + 1]; // ↙ 前缀和
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                diagSum[i + 1][j + 1] = diagSum[i][j] + v;
                antiSum[i + 1][j] = antiSum[i][j + 1] + v;
            }
        }

        // 枚举菱形正中心 (i,j)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(grid[i][j]); // 一个数也算菱形
                // 枚举菱形顶点到正中心的距离 k，注意菱形顶点不能出界
                // i-k >= 0 且 i+k <= m-1，所以 k <= min(i, m-1-i)，对于 j 同理
                int mx = Math.min(Math.min(i, m - 1 - i), Math.min(j, n - 1 - j));
                for (int k = 1; k <= mx; k++) {
                    int a = queryDiagonal(diagSum, i - k, j, k); // 菱形右上的边
                    int b = queryDiagonal(diagSum, i, j - k, k); // 菱形左下的边
                    int c = queryAntiDiagonal(antiSum, i - k + 1, j - 1, k - 1); // 菱形左上的边
                    int d = queryAntiDiagonal(antiSum, i, j + k, k + 1); // 菱形右下的边
                    update(a + b + c + d);
                }
            }
        }

        int[] ans = new int[]{x, y, z};
        int len = 3;
        while (ans[len - 1] == 0) { // 不同的和少于三个
            len--;
        }
        return Arrays.copyOf(ans, len);
    }

    // 从 (x,y) 开始，向 ↘，连续 k 个数的和
    private int queryDiagonal(int[][] diagSum, int x, int y, int k) {
        return diagSum[x + k][y + k] - diagSum[x][y];
    }

    // 从 (x,y) 开始，向 ↙，连续 k 个数的和
    private int queryAntiDiagonal(int[][] antiSum, int x, int y, int k) {
        return antiSum[x + k][y + 1 - k] - antiSum[x][y + 1];
    }

    private void update(int v) {
        if (v > x) {
            z = y;
            y = x;
            x = v;
        } else if (v < x && v > y) {
            z = y;
            y = v;
        } else if (v < y && v > z) {
            z = v;
        }
    }
}