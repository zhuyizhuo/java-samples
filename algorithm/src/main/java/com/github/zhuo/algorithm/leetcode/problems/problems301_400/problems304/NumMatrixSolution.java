package com.github.zhuo.algorithm.leetcode.problems.problems301_400.problems304;

public class NumMatrixSolution {

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
}
