package com.github.zhuo.algorithm.leetcode.problems.problems1701_1800;

/**
 * 重新排列后的最大子矩阵
 *
 * 给你一个二进制矩阵 matrix ，它的大小为 m x n ，你可以将 matrix 中的 列 按任意顺序重新排列。
 *
 * 请你返回最优方案下将 matrix 重新排列后，全是 1 的子矩阵面积。
 */
public class Solution1727 {

    /**
     * beats 100%
     */
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix[0].length;
        int[] heights = new int[n];
        int[] idx = new int[n]; // 按照高度排序后的列号
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        int[] nonZeros = new int[n]; // 避免在循环内反复申请内存
        int ans = 0;

        for (int[] row : matrix) {
            int p = 0;
            int q = 0;
            for (int j : idx) {
                if (row[j] == 0) {
                    heights[j] = 0;
                    idx[p++] = j; // 高度 0 排在前面
                } else {
                    heights[j]++;
                    nonZeros[q++] = j;
                }
            }

            // heights[idx[i]] 是递增的
            for (int i = p; i < n; i++) { // 高度 0 无需计算
                idx[i] = nonZeros[i - p]; // 把 nonZeros 复制到 idx 的 [p,n-1] 中
                ans = Math.max(ans, (n - i) * heights[idx[i]]);
            }
        }

        return ans;
    }
}