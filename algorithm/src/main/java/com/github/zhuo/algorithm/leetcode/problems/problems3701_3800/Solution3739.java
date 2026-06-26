package com.github.zhuo.algorithm.leetcode.problems.problems3701_3800;

/**
 * 统计主要元素子数组数目 II
 * hard
 * 给你一个整数数组 nums 和一个整数 target。
 *
 * 返回数组 nums 中满足 target 是 主要元素 的 子数组 的数目。
 *
 * 一个子数组的 主要元素 是指该元素在该子数组中出现的次数 严格大于 其长度的 一半 。
 *
 * 子数组 是数组中的一段连续且 非空 的元素序列。
 */
public class Solution3739 {

    /**
     * beats 100%
     */
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        // 表示前缀和为 -n, -(n-1), ..., 0, 1, ..., n 的出现次数，下标偏移 n
        int[] pre = new int[n * 2 + 1];
        pre[n] = 1;
        int cnt = n;
        long ans = 0, presum = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == target) {
                presum += pre[cnt];
                ++cnt;
                ++pre[cnt];
            } else {
                --cnt;
                presum -= pre[cnt];
                ++pre[cnt];
            }
            ans += presum;
        }
        return ans;
    }
}