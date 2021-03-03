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
public class NumArraySecond {

    private int[] nums;
    private int[] sums;

    public NumArraySecond(int[] nums) {
        this.nums = nums;
        sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sums[i] = sum;
        }
    }

    /**
     * 预处理法 前缀和算法
     *
     * 执行用时： 10 ms , 在所有 Java 提交中击败了 76.97% 的用户
     * 内存消耗： 41.4 MB , 在所有 Java 提交中击败了 40.22% 的用户
     */
    public int sumRange(int i, int j) {
        return sums[j] - sums[i] + nums[i];
    }
}
