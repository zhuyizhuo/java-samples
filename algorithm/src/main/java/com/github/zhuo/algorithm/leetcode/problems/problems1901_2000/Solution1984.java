package com.github.zhuo.algorithm.leetcode.problems.problems1901_2000;

import java.util.Arrays;

/**
 * 学生分数的最小差值
 *
 * 给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。
 *
 * 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。
 *
 * 返回可能的 最小差值 。
 */
public class Solution1984 {

    /**
     * beats 99.35%
     */
    private void sort(int[] nums, int start, int end) {
        int mid = nums[start + ((end - start) >>> 1)];
        int i = start;
        int j = end;
        do {
            while (nums[i] > mid) {
                i++;
            }
            while (nums[j] < mid) {
                j--;
            }
            if (i <= j) {
                int r = nums[i];
                nums[i] = nums[j];
                nums[j] = r;
                i++;
                j--;
            }
        } while (i <= j);
        if (i < end) {
            sort(nums, i, end);
        }
        if (start < j) {
            sort(nums, start, j);
        }
    }

    public int minimumDifference(int[] nums, int k) {
        sort(nums, 0, nums.length - 1);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            int t = nums[i] - nums[i + k - 1];
            if (ans > t) {
                ans = t;
            }
        }
        return ans;
    }
}