package com.github.zhuo.algorithm.leetcode.problems1_100.problems26;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,3,4};
        int x = removeDuplicates(nums);
        System.out.println(x);
        for (int i = 0; i < x; i++) {
            System.out.println(nums[i]);
        }
    }

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
