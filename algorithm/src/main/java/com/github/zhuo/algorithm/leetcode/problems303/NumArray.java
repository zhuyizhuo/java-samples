package com.github.zhuo.algorithm.leetcode.problems303;

/**
 * https://leetcode-cn.com/problems/range-sum-query-immutable/
 * 区域和检索 - 数组不可变
 * 难度 简单
 * 
 * 给定一个整数数组 nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
 *
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 *
 */
public class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    /**
     * 循环累加法
     *
     * 执行用时： 88 ms , 在所有 Java 提交中击败了 9.08% 的用户
     * 内存消耗： 41.3 MB , 在所有 Java 提交中击败了 59.86% 的用户
     */
    public int sumRange(int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += nums[k];
        }
        return sum;
    }
}
