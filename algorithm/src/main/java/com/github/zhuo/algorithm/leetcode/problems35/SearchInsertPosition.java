package com.github.zhuo.algorithm.leetcode.problems35;

/**
 * https://leetcode.com/problems/search-insert-position/
 *
 * 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,2,3,5}, 5));
    }

    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num >= target) {
                return i;
            }
        }
        return nums.length;
    }

}
