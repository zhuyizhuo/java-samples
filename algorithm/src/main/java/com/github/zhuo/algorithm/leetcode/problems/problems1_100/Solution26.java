package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array
 * 删除有序数组中的重复项
 * 难度 简单
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Solution26 {

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4};
        int x = removeDuplicates(nums);
        System.out.println(x);
        for (int i = 0; i < x; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 81.45% 的用户
     * 内存消耗： 40 MB , 在所有 Java 提交中击败了 91.89% 的用户
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int index = 1;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (last != nums[i]){
                index ++;
                last = nums[i];
            }
            nums[index - 1] = nums[i];
        }
        return index;
    }

}
