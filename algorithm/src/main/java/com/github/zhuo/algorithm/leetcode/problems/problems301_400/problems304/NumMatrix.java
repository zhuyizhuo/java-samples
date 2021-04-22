package com.github.zhuo.algorithm.leetcode.problems.problems301_400.problems304;

/**
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 * 二维区域和检索 - 矩阵不可变
 * 难度 中等
 *
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 *
 */
public class NumMatrix {
    int[][] sums;

    /**
     * 一维前缀和 先计算每行的子数组和
     */
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sums = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i][j + 1] = sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    /**
     * 执行用时： 15 ms , 在所有 Java 提交中击败了 60.40% 的用户
     * 内存消耗： 44.2 MB , 在所有 Java 提交中击败了 15.48% 的用户
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            //
            sum += sums[i][col2 + 1] - sums[i][col1];
        }
        return sum;
    }

}
