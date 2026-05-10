package com.github.zhuo.algorithm.leetcode.problems.problems2701_2800;

/**
 * 达到末尾下标所需的最大跳跃次数
 *
 * 给你一个下标从 0 开始、由 n 个整数组成的数组 nums 和一个整数 target 。
 *
 * 你的初始位置在下标 0 。在一步操作中，你可以从下标 i 跳跃到任意满足下述条件的下标 j ：
 *
 * 0 <= i < j < n
 * -target <= nums[j] - nums[i] <= target
 * 返回到达下标 n - 1 处所需的 最大跳跃次数 。
 *
 * 如果无法到达下标 n - 1 ，返回 -1 。
 */
public class Solution2770 {

    /**
     * beats 100%
     */
    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i ++) {
            if (i != 0 && dp[i] == 0) continue;
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[j] - nums[i] >= - target && nums[j] - nums[i] <= target) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }
        return dp[nums.length - 1] == 0 ? -1 : dp[nums.length - 1];
    }
}