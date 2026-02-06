package com.github.zhuo.algorithm.leetcode.problems.problems3601_3700;

import java.util.Arrays;

/**
 * 使数组平衡的最少移除数目
 *
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果一个数组的 最大 元素的值 至多 是其 最小 元素的 k 倍，则该数组被称为是 平衡 的。
 *
 * 你可以从 nums 中移除 任意 数量的元素，但不能使其变为 空 数组。
 *
 * 返回为了使剩余数组平衡，需要移除的元素的 最小 数量。
 *
 * 注意：大小为 1 的数组被认为是平衡的，因为其最大值和最小值相等，且条件总是成立。
 */
public class Solution3634 {

    /**
     * beats 34.93%
     */
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int maxLen = 0;

        for (int j = 0; j < nums.length; j++) {
            while ((long) nums[j] > (long) nums[i] * k) {
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return nums.length - maxLen;
    }
}