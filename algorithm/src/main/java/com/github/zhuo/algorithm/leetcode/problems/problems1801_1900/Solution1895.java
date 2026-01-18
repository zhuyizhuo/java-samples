package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900;

/**
 * 一个 k x k 的 幻方 指的是一个 k x k 填满整数的方格阵，且每一行、每一列以及两条对角线的和 全部相等 。幻方中的整数 不需要互不相同 。显然，每个 1 x 1 的方格都是一个幻方。
 *
 * 给你一个 m x n 的整数矩阵 grid ，请你返回矩阵中 最大幻方 的 尺寸 （即边长 k）。
 */
public class Solution1895 {
    /***
     * beats 98.73%
     */
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 每一行的前缀和
        int[][] rowsum = new int[m][n];
        for (int i = 0; i < m; ++i) {
            rowsum[i][0] = grid[i][0];
            for (int j = 1; j < n; ++j) {
                rowsum[i][j] = rowsum[i][j - 1] + grid[i][j];
            }
        }
        // 每一列的前缀和
        int[][] colsum = new int[m][n];
        for (int j = 0; j < n; ++j) {
            colsum[0][j] = grid[0][j];
            for (int i = 1; i < m; ++i) {
                colsum[i][j] = colsum[i - 1][j] + grid[i][j];
            }
        }

        // 从大到小枚举边长 edge
        for (int edge = Math.min(m, n); edge >= 2; --edge) {
            // 枚举正方形的左上角位置 (i,j)
            for (int i = 0; i + edge <= m; ++i) {
                for (int j = 0; j + edge <= n; ++j) {
                    // 计算每一行、列、对角线的值应该是多少（以第一行为样本）
                    int stdsum = rowsum[i][j + edge - 1] - (j > 0 ? rowsum[i][j - 1] : 0);
                    boolean check = true;
                    // 枚举每一行并用前缀和直接求和
                    for (int ii = i + 1; ii < i + edge; ++ii) {
                        if (rowsum[ii][j + edge - 1] - (j > 0 ? rowsum[ii][j - 1] : 0) != stdsum) {
                            check = false;
                            break;
                        }
                    }
                    if (!check) continue;
                    // 枚举每一列并用前缀和直接求和
                    for (int jj = j; jj < j + edge; ++jj) {
                        if (colsum[i + edge - 1][jj] - (i > 0 ? colsum[i - 1][jj] : 0) != stdsum) {
                            check = false;
                            break;
                        }
                    }
                    if (!check) continue;
                    // 两条对角线的和
                    int d1 = 0, d2 = 0;
                    for (int k = 0; k < edge; ++k) {
                        d1 += grid[i + k][j + k];
                        d2 += grid[i + k][j + edge - 1 - k];
                    }
                    if (d1 == stdsum && d2 == stdsum) {
                        return edge;
                    }
                }
            }
        }
        return 1;
    }
}

/**
 * beats 100%
 */
class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rowPrefixSum = new int[m][n + 1];
        int[][] colPrefixSum = new int[n][m + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowPrefixSum[i][j + 1] = rowPrefixSum[i][j] + grid[i][j];
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                colPrefixSum[j][i + 1] = colPrefixSum[j][i] + grid[i][j];
            }
        }
        for (int size = Math.min(m, n); size > 1; size--) {
            for (int i = 0; i <= m - size; i++) {
                for (int j = 0; j <= n - size; j++) {
                    if (isMagicSquare(grid, rowPrefixSum, colPrefixSum, size, i, j)) {
                        return size;
                    }
                }
            }
        }
        return 1;
    }

    private boolean isMagicSquare(int[][] grid, int[][] rowPrefixSum,
                                  int[][] colPrefixSum, int size, int i, int j) {
        int sum = rowPrefixSum[i][j + size] - rowPrefixSum[i][j];
        int diagonalSum = 0, antidiagonalSum = 0;
        for (int k = 0; k < size; k++) {
            if (rowPrefixSum[i + k][j + size] - rowPrefixSum[i + k][j] != sum) {
                return false;
            }
            if (colPrefixSum[j + k][i + size] - colPrefixSum[j + k][i] != sum) {
                return false;
            }
            diagonalSum += grid[i + k][j + k];
            antidiagonalSum += grid[i + k][j + size - 1 - k];
        }
        return sum == diagonalSum && sum == antidiagonalSum;
    }
}