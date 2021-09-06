package com.github.zhuo.algorithm.leetcode.problems.problems701_800.problems704;

/**
 * https://leetcode-cn.com/problems/binary-search/
 *
 * 二分查找
 *
 * 难度 简单
 */
public class BinarySearch {

    /**
     * 暴力解法 与题意不符
     */
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}
