package com.github.zhuo.algorithm.leetcode.problems.problems2101_2200;

import java.util.Arrays;

/**
 * 根据给定数字划分数组
 *
 */
public class Solution2161 {

    /**
     * beats 73.56%
     */
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, pivot);
        int left = 0, right = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                ans[left] = nums[i];
                left++;
            } else if (nums[i] > pivot) {
                ans[right] = nums[i];
                right--;
            }
        }
        reverse(ans, right + 1, n - 1);
        return ans;
    }

    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}