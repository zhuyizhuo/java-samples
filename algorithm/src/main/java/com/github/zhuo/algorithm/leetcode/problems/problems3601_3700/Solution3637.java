package com.github.zhuo.algorithm.leetcode.problems.problems3601_3700;

/**
 * 三段式数组 I
 * easy
 *
 * 给你一个长度为 n 的整数数组 nums。
 *
 * 如果存在索引 0 < p < q < n − 1，使得数组满足以下条件，则称其为 三段式数组（trionic）：
 *
 * nums[0...p] 严格 递增，
 * nums[p...q] 严格 递减，
 * nums[q...n − 1] 严格 递增。
 * 如果 nums 是三段式数组，返回 true；否则，返回 false。
 */
public class Solution3637 {
    /**
     * beats 95.74%
     */
    public boolean isTrionic(int[] nums) {
        int len = nums.length;
        int p = 1;
        while (p < len && nums[p] > nums[p - 1]) {
            p++;
        }
        int q = p;
        while (q < len && nums[q - 1] > nums[q]) {
            q++;
        }
        int t = q;
        while (t < len && nums[t - 1] < nums[t]) {
            t++;
        }
        return p < q && q < t && p < t && p > 1 && t == len;
    }
}