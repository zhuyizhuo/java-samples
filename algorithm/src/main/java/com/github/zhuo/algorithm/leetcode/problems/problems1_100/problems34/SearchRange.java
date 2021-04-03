package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems34;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 */
public class SearchRange {

    public static void main(String[] args) {
        //TODO 进阶 O(log n) 时间复杂度的实现
    }

    /**
     * 暴力算法 先解出来
     *
     * O(n) 时间复杂度
     */
    public int[] searchRange(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                for (int j = nums.length - 1; j > i; j--) {
                    if (nums[j] == target){
                        return new int[]{i, j};
                    }
                }
                return new int[]{i, i};
            }
        }
        return new int[]{-1, -1};
    }
}
