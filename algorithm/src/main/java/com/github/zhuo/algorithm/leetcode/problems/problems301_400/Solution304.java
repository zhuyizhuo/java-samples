package com.github.zhuo.algorithm.leetcode.problems.problems301_400;

/**
 * https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 * 二维区域和检索 - 矩阵不可变
 * 难度 中等
 *
 * 给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。
 *
 */
public class Solution304 {
    int[][] sums;

    /**
     * 一维前缀和 先计算每行的子数组和
     */
    public Solution304(int[][] matrix) {
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

class NumMatrixSolution {

    int[][] sum;
    /**
     * 二维前缀和
     */
    public NumMatrixSolution(int[][] matrix) {
        sum = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum[i+1][j+1] = sum[i][j+1] + sum[i+1][j] - sum[i][j] + matrix[i][j];
            }
        }
    }

    /**
     * 返回的区域和等于大区域的和 减去 左边和上边区域 加上 两个区域重叠的部分(多减了一次)
     * 执行用时： 15 ms , 在所有 Java 提交中击败了 72.94% 的用户
     * 内存消耗： 44 MB , 在所有 Java 提交中击败了 65.52% 的用户
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1] - sum[row2+1][col1] - sum[row1][col2+1] + sum[row1][col1];
    }

    public static void main(String[] args) {
        NumMatrixSolution numMatrixSolution = new NumMatrixSolution(new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}});
        System.out.println(numMatrixSolution.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrixSolution.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrixSolution.sumRegion(1, 2, 2, 4));
    }
}
