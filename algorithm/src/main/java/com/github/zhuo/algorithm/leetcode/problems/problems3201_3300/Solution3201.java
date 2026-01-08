package com.github.zhuo.algorithm.leetcode.problems.problems3201_3300;

/**
 * 给你一个整数数组 nums。
 *
 * nums 的子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列：
 *
 * (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2
 * 返回 nums 的 最长的有效子序列 的长度。
 *
 * 一个 子序列 指的是从原数组中删除一些元素（也可以不删除任何元素），剩余元素保持原来顺序组成的新数组。
 *
 *
 * 示例 1：
 *
 * 输入： nums = [1,2,3,4]
 *
 * 输出： 4
 *
 * 解释：
 *
 * 最长的有效子序列是 [1, 2, 3, 4]。
 *
 * 示例 2：
 *
 * 输入： nums = [1,2,1,1,2,1,2]
 *
 * 输出： 6
 *
 * 解释：
 *
 * 最长的有效子序列是 [1, 2, 1, 2, 1, 2]。
 *
 * 示例 3：
 *
 * 输入： nums = [1,3]
 *
 * 输出： 2
 *
 * 解释：
 *
 * 最长的有效子序列是 [1, 3]。
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 2 * 10^5
 * 1 <= nums[i] <= 10^7
 */
public class Solution3201 {

    /**
     * 3ms beats 100%
     */
    public int maximumLength(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1], pre = new int[2], parity = new int[2];
        for(int i = 0; i < len; i++){
            int idx = nums[i] % 2;
            dp[i + 1] = dp[pre[idx ^ 1]] + 1;
            pre[idx] = i + 1;
            parity[idx]++;
        }
        return Math.max(Math.max(dp[pre[0]], dp[pre[1]]), Math.max(parity[0], parity[1]));
    }
}
