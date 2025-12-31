package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation/
 * 还原排列的最少操作步数
 * 难度 中等
 * 
 * 给你一个偶数 n ，已知存在一个长度为 n 的排列 perm ，其中 perm[i] == i（下标 从 0 开始 计数）。
 *
 * 一步操作中，你将创建一个新数组 arr ，对于每个 i ：
 *
 * 如果 i % 2 == 0 ，那么 arr[i] = perm[i / 2]
 * 如果 i % 2 == 1 ，那么 arr[i] = perm[n / 2 + (i - 1) / 2]
 * 然后将 arr  赋值 给 perm 。
 *
 * 要想使 perm 回到排列初始值，至少需要执行多少步操作？返回最小的 非零 操作步数。
 *
 * 提示：
 *
 * 2 <= n <= 1000
 * n 是一个偶数
 */
public class Solution1806 {

    public static void main(String[] args) {
    }

    /**
     * beats 100%
     */
    public int reinitializePermutation(int n) {
        if (n == 2) {
            return 1;
        }
        int step = 1, pow2 = 2;
        while (pow2 != 1) {
            step++;
            pow2 = pow2 * 2 % (n - 1);
        }
        return step;
    }}
