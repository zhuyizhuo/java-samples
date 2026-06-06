package com.github.zhuo.algorithm.leetcode.problems.problems2501_2600;

/**
 * 左右元素和的差值
 * easy
 *
 * 给你一个下标从 0 开始的长度为 n 的整数数组 nums。
 *
 * 定义两个数组 leftSum 和 rightSum，其中：
 *
 * leftSum[i] 是数组 nums 中下标 i 左侧元素之和。如果不存在对应的元素，leftSum[i] = 0 。
 * rightSum[i] 是数组 nums 中下标 i 右侧元素之和。如果不存在对应的元素，rightSum[i] = 0 。
 * 返回长度为 n 数组 answer，其中 answer[i] = |leftSum[i] - rightSum[i]|。
 */
public class Solution2574 {

    /**
     * beats 100%
     */
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        int leftSum = 0;
        for (int i = 0; i < n; ++i) {
            ans[i] = leftSum;
            leftSum += nums[i];
        }

        int rightSum = 0;
        for (int i = n - 1; i >= 0; --i) {
            ans[i] = Math.abs(ans[i] - rightSum);
            rightSum += nums[i];
        }

        return ans;
    }
}