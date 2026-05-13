package com.github.zhuo.algorithm.leetcode.problems.problems1601_1700;

/**
 * 使数组互补的最少操作次数
 *
 * 给你一个长度为 偶数 n 的整数数组 nums 和一个整数 limit 。每一次操作，你可以将 nums 中的任何整数替换为 1 到 limit 之间的另一个整数。
 *
 * 如果对于所有下标 i（下标从 0 开始），nums[i] + nums[n - 1 - i] 都等于同一个数，则数组 nums 是 互补的 。例如，数组 [1,2,3,4] 是互补的，因为对于所有下标 i ，nums[i] + nums[n - 1 - i] = 5 。
 *
 * 返回使数组 互补 的 最少 操作次数。
 */
public class Solution1674 {

    /**
     * beats 100%
     */
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i], b = nums[n - 1 - i];
            int low = Math.min(a, b) + 1;
            int high = Math.max(a, b) + limit;

            diff[2] += 2;
            diff[low] -= 1;
            diff[a + b] -= 1;
            diff[a + b + 1] += 1;
            diff[high + 1] += 1;
        }

        int ans = Integer.MAX_VALUE;
        int curr = 0;

        for (int sum = 2; sum <= 2 * limit; sum++) {
            curr += diff[sum];
            ans = Math.min(ans, curr);
        }

        return ans;
    }

}