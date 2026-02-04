package com.github.zhuo.algorithm.leetcode.problems.problems3601_3700;

/**
 * 三段式数组 II
 * hard
 *
 * 给你一个长度为 n 的整数数组 nums。
 *
 * 三段式子数组 是一个连续子数组 nums[l...r]（满足 0 <= l < r < n），并且存在下标 l < p < q < r，使得：
 *
 * nums[l...p] 严格 递增，
 * nums[p...q] 严格 递减，
 * nums[q...r] 严格 递增。
 * 请你从数组 nums 的所有三段式子数组中找出和最大的那个，并返回其 最大 和。
 */
public class Solution3640 {
    /**
     * beats 94.87%
     */
    public long maxSumTrionic(int[] nums) {
        int last = nums[0];
        // 状态，0开始，1第一段-升、2第二段-降、3第三段-升
        long ans = Long.MIN_VALUE;
        long min = 0;
        long lastMin = 0;
        long preAll = last;
        long preUp = last;
        int status = 0;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > last) {
                // 当前递增
                // 如果当前处于0，则更新为下一阶段，
                lastMin = min;
                min = Math.min(min, preUp);
                preAll += num;
                switch (status) {
                    case 0:
                        status = 1;
                        preUp += num;
                        break;
                    case 1:
                        preUp += num;
                        break;
                    case 2:
                        status = 3;
                        preUp += num;
                        ans = Math.max(ans, preAll);
                        break;
                    case 3:
                        preUp += num;
                        ans = Math.max(ans, preAll);
                        break;
                }
            } else if (num < last) {
                // 当前递减
                if (status == 1 || status == 3) {
                    preAll = preUp - lastMin;
                    min = 0;
                    lastMin = 0;
                    status = 2;
                } else if (status == 0) {
                    preAll = 0;
                    preUp = num;
                }
                if (status == 2) {
                    preUp = num;
                }
                preAll += num;
            } else {
                min = 0;
                lastMin = 0;
                preUp = num;
                preAll = num;
                status = 0;
            }
            last = num;
        }
        return ans;
    }
}