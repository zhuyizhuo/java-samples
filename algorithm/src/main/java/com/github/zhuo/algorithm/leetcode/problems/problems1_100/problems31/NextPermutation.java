package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems31;

/**
 *
 */
public class NextPermutation {

    public static void main(String[] args) {
        //TODO  此题是否约束条件有误  已反馈
        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * [3,2,1]
     * [1,2,2,1]
     * [1,3,4,35,24,4]  ->  [1,3,24,4,4,35]
     * [1,3,3,2]
     * [1,3,2] 预期 [2,1,3]
     * [3,1,2]   [3,2,1]
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1){
            return;
        }
        int left = 0;
        int right = nums.length - 1;

        return;
    }
}
