package com.github.zhuo.algorithm.leetcode.problems.problems1201_1300;

/**
 * 元素和小于等于阈值的正方形的最大边长
 *
 * 给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。
 *
 * 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。
 */
public class Solution1292 {
    /**
     * 5ms beats 99.49%
     */
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] s = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                s[i + 1][j + 1] = s[i][j + 1] + s[i + 1][j] - s[i][j] + mat[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                while (i + ans < m && j + ans < n
                        && s[i + ans + 1][j + ans + 1] - s[i][j + ans + 1] - s[i + ans + 1][j] + s[i][j] <= threshold) {
                    ans++;
                }
            }
        }
        return ans;
    }
}