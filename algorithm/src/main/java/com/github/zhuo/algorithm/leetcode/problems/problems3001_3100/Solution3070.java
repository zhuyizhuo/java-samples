package com.github.zhuo.algorithm.leetcode.problems.problems3001_3100;

/**
 * 元素和小于等于 k 的子矩阵的数目
 *
 * 给你一个下标从 0 开始的整数矩阵 grid 和一个整数 k。
 *
 * 返回包含 grid 左上角元素、元素和小于或等于 k 的 子矩阵的数目。
 */
public class Solution3070 {

    /**
     * beats 100%
     */
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        int[] cols = new int[n];
        int res = 0;
        for(int i = 0; i < m; i++){
            int rows = 0;
            for(int j = 0; j < n; j++){
                cols[j] += grid[i][j];
                rows += cols[j];
                if(rows <= k)
                    res++;
            }
        }

        return res;
    }
}