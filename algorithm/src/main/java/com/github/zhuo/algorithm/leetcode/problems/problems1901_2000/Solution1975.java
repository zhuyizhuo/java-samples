package com.github.zhuo.algorithm.leetcode.problems.problems1901_2000;

/**
 * 最大方阵和
 *
 * 给你一个 n x n 的整数方阵 matrix 。你可以执行以下操作 任意次 ：
 *
 * 选择 matrix 中 相邻 两个元素，并将它们都 乘以 -1 。
 * 如果两个元素有 公共边 ，那么它们就是 相邻 的。
 *
 * 你的目的是 最大化 方阵元素的和。请你在执行以上操作之后，返回方阵的 最大 和。
 *
 */
public class Solution1975 {

    /**
     * beats 100%
     */
    public long maxMatrixSum(int[][] matrix) {
        // 贪心
        int mn = Integer.MAX_VALUE;
        int nav = 0;

        long res = 0;
        // 任意两个负数肯定可以同时乘上-1变为正数
        for (int[] arr: matrix) {
            for (int x: arr) {
                if (x < 0) {
                    nav++;
                    x = -x;
                }
                mn = Math.min(mn, x);
                res += x;
            }
        }

        if (nav % 2 == 1) {
            res -= mn * 2;
        }

        return res;
    }

}