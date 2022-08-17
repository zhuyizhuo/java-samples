package com.github.zhuo.algorithm.leetcode.problems.problems701_800.problems704;

/**
 * https://leetcode-cn.com/problems/binary-search/
 *
 * 二分查找
 *
 * 难度 简单
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(search1(nums, 6));
        System.out.println(search1(nums, 1));
        System.out.println(search1(nums, 5));
        System.out.println(search1(nums, 2));
    }

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

    public static int search1(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start < end){
            int index = (start + end)/2;
            if (nums[index] == target){
                return index;
            } if (nums[index] > target){
                start = index;
            } else {
                end = index;
            }
        }
        return -1;
    }
}
