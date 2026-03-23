package com.github.zhuo.algorithm.leetcode.problems.problems1501_1600;

/**
 * 矩阵的最大非负积
 *
 * 给你一个大小为 m x n 的矩阵 grid 。最初，你位于左上角 (0, 0) ，每一步，你可以在矩阵中 向右 或 向下 移动。
 *
 * 在从左上角 (0, 0) 开始到右下角 (m - 1, n - 1) 结束的所有路径中，找出具有 最大非负积 的路径。路径的积是沿路径访问的单元格中所有整数的乘积。
 *
 * 返回 最大非负积 对 10^9 + 7 取余 的结果。如果最大积为 负数 ，则返回 -1 。
 *
 * 注意，取余是在得到最大积之后执行的。
 */
public class Solution1594 {

    /**
     * beats 100%
     * 这种题目的核心是动态规划,即当前的内容取决于之前的状态
     */
    public int maxProductPath(int[][] grid) {
        // 记录一个最大值
        final int MOD = 1000000000 + 7;
        // 分别获得矩阵的长和宽
        int m = grid.length, n = grid[0].length;
        long[][] maxgt = new long[m][n];
        long[][] minlt = new long[m][n];
        // 需要两个节点的原因是需要存储最大值和最小值(因为当前节点的值可能是负数,因此需要同时存储最大值和最小值)
        maxgt[0][0] = minlt[0][0] = grid[0][0];
        // 首先是确定边界,因为第一行和第一列其实只有一个来源(即左边和上边),所以其最大值和最小值实际上是确定了的,因此直接累乘即可
        for (int i = 1; i < n; i++) {
            maxgt[0][i] = minlt[0][i] = maxgt[0][i - 1] * grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            maxgt[i][0] = minlt[i][0] = maxgt[i - 1][0] * grid[i][0];
        }
        // 接下来处理平常的内容
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 如果当前的位置的值大于0,则最大值就是 当前值*前一个节点的最大值(前一个节点可能是左边也可能是上边,因此使用max)
                // 最小值就是 当前值*前一个节点的最小值(前一个节点可能是左边也可能是上边,因此使用min)
                if (grid[i][j] >= 0) {
                    maxgt[i][j] = Math.max(maxgt[i][j - 1], maxgt[i - 1][j]) * grid[i][j];
                    minlt[i][j] = Math.min(minlt[i][j - 1], minlt[i - 1][j]) * grid[i][j];
                } else {
                    // 如果当前的位置的值小于0,则最大值就是 当前值*前一个节点的最小值(前一个节点可能是左边也可能是上边,因此使用min)
                    // 最小值就是 当前值*前一个节点的最大值(前一个节点可能是左边也可能是上边,因此使用max)
                    maxgt[i][j] = Math.min(minlt[i][j - 1], minlt[i - 1][j]) * grid[i][j];
                    minlt[i][j] = Math.max(maxgt[i][j - 1], maxgt[i - 1][j]) * grid[i][j];
                }
            }
        }
        // 如果算出来最后的位置小于零就返回-1
        if (maxgt[m - 1][n - 1] < 0) {
            return -1;
        } else {
            return (int) (maxgt[m - 1][n - 1] % MOD);
        }
    }
}