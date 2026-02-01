package com.github.zhuo.algorithm.leetcode.problems.problems3001_3100;

/**
 * 将数组分成最小总代价的子数组 I
 * easy
 *
 * 给你一个长度为 n 的整数数组 nums 。
 *
 * 一个数组的 代价 是它的 第一个 元素。比方说，[1,2,3] 的代价是 1 ，[3,4,1] 的代价是 3 。
 *
 * 你需要将 nums 分成 3 个 连续且没有交集 的子数组。
 *
 * 请你返回这些子数组的 最小 代价 总和 。
 */
public class Solution3010 {
    /**
     * beats 99.2%
     */
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE / 2;
        for (int i = 1; i < n; i++) {
            if (nums[i] < min) {
                secondMin = min;
                min = nums[i];
            } else if (nums[i] < secondMin) {
                secondMin = nums[i];
            }
        }
        return nums[0] + min + secondMin;
    }
}