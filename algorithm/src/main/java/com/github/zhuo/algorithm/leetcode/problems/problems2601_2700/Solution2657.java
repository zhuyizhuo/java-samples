package com.github.zhuo.algorithm.leetcode.problems.problems2601_2700;

/**
 * 找到两个数组的前缀公共数组
 *
 * 给你两个下标从 0 开始长度为 n 的整数排列 A 和 B 。
 *
 * A 和 B 的 前缀公共数组 定义为数组 C ，其中 C[i] 是数组 A 和 B 到下标为 i 之前公共元素的数目。
 *
 * 请你返回 A 和 B 的 前缀公共数组 。
 *
 * 如果一个长度为 n 的数组包含 1 到 n 的元素恰好一次，我们称这个数组是一个长度为 n 的 排列 。
 */
public class Solution2657 {

    /**
     * beats 100%
     */
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        int[] count = new int[n + 1]; // 计数数组，索引代表数字
        int common = 0; // 当前公共元素个数

        for (int i = 0; i < n; i++) {
            // 处理 A 数组的当前元素
            if (++count[A[i]] == 2) common++;
            // 处理 B 数组的当前元素
            if (++count[B[i]] == 2) common++;

            res[i] = common;
        }
        return res;
    }
}