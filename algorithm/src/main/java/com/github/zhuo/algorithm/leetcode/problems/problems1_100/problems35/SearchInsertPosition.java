package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems35;

/**
 * https://leetcode.com/problems/search-insert-position/
 *
 * 搜索插入位置
 *
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 
 * 提示:
 *
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 为 无重复元素 的 升序 排列数组
 * -10^4 <= target <= 10^4
 *
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert1(new int[]{1,2,3,5}, 6));
        System.out.println(searchInsert1(new int[]{1,3,5,6}, 2));
    }

    /**
     * 二分查找
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 41.3 MB , 在所有 Java 提交中击败了 19.54% 的用户
     * 通过测试用例： 64 / 64
     */
    public static int searchInsert1(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            int middle = start + (end - start)/2;
            if (nums[middle] == target){
                return middle;
            }
            if (nums[middle] < target){
                start = middle + 1;
            } else {
                end = middle;
            }
        }
        if (nums[start] >= target){
            return start;
        } else {
            return start + 1;
        }
    }

    /**
     * 暴力解 与题意不符
     */
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
