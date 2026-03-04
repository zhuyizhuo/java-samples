package com.github.zhuo.algorithm.leetcode.problems.problems1501_1600;

/**
 * 二进制矩阵中的特殊位置
 * easy
 *
 * 给定一个 m x n 的二进制矩阵 mat，返回矩阵 mat 中特殊位置的数量。
 *
 * 如果位置 (i, j) 满足 mat[i][j] == 1 并且行 i 与列 j 中的所有其他元素都是 0（行和列的下标从 0 开始计数），那么它被称为 特殊 位置。
 */
public class Solution1582 {

    /**
     * beats 94.84%
     */
    public int numSpecial(int[][] mat) {
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        for  (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    rows[i] ++;
                    cols[j] ++;
                }
            }
        }
        int ans = 0;
        for  (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && rows[i] == 1 &&  cols[j] == 1) {
                    ans ++;
                }
            }
        }
        return ans;
    }
}