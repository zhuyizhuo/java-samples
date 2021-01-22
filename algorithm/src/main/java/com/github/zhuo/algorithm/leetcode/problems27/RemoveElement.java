package com.github.zhuo.algorithm.leetcode.problems27;

/**
 *
 * https://leetcode.com/problems/remove-element/
 *
 * 此题解法执行用时 0ms 超过 100% 的用户 舒服
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int i = removeElement(nums, 2);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }
        int index = nums.length;
        for (int i = 0; i < index; i++) {
            if (nums[i] == val) {
                for (int j = i; j < index - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                index--;
                i--;
            }
        }
        return index;
    }
}
