package com.github.zhuo.algorithm.leetcode.problems.problems2901_3000;

/**
 * 循环移位后的矩阵相似检查
 * easy
 *
 * 给你一个下标从 0 开始且大小为 m x n 的整数矩阵 mat 和一个整数 k 。请你将矩阵中的 奇数 行循环 右 移 k 次，偶数 行循环 左 移 k 次。
 *
 * 如果初始矩阵和最终矩阵完全相同，则返回 true ，否则返回 false 。
 */
public class Solution2946 {

    /**
     * beats 100%
     */
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length;

        for (int[] row : mat) {
            for (int j = 0; j < n; j++) {
                if (row[j] != row[(k + j) % n]) {
                    return false;
                }
            }
        }
        return true;
    }
}