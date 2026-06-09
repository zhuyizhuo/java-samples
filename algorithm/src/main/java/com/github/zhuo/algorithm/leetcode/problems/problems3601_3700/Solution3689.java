package com.github.zhuo.algorithm.leetcode.problems.problems3601_3700;

/**
 * 最大子数组总值 I
 */
public class Solution3689 {

    /**
     * beats 100%
     */
    public long maxTotalValue(int[] nums, int k) {
        int m1 = Integer.MAX_VALUE, m2 = Integer.MIN_VALUE;
        for (int x : nums) {
            m1 = Math.min(m1, x);
            m2 = Math.max(m2, x);
        }
        return (long)(m2 - m1) * k;
    }
}