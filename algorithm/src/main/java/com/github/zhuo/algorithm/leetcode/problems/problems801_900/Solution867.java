package com.github.zhuo.algorithm.leetcode.problems.problems801_900;

/**
 * https://leetcode-cn.com/problems/transpose-matrix/
 *
 * 转置矩阵
 *
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 *
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 * 提示
 *   m == matrix.length
 *   n == matrix[i].length
 *   1 <= m, n <= 1000
 *   1 <= m * n <= 10^5
 *   -10^9 <= matrix[i][j] <= 10^9
 *
 *  m 与 n 不一定相等
 */
public class Solution867 {

    public static void main(String[] args) {
        System.out.println();
    }

    /**
     * 转置即将行变列 将列变行
     *
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 39.3 MB , 在所有 Java 提交中击败了 67.40% 的用户
     */
    public static int[][] transpose(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        //将原数组的行列 转为新数组的列和行
        int[][] resp = new int[colLength][rowLength];
        int col = 0;
        for (int i = 0; i < rowLength; i++) {
            int row = 0;
            for (int j = 0; j < colLength; j++) {
                resp[row][col] = matrix[i][j];
                row++;
            }
            col++;
        }
        return resp;
    }

}
