package com.github.zhuo.algorithm.leetcode.problems.problems601_700;

/**
 * https://leetcode.com/problems/longest-continuous-increasing-subsequence/
 */
public class Solution674 {

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1,3,5,4,2,3,4,5}));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int max = 1;
        int sum = 1;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > last){
                sum ++;
            } else {
                sum = 1;
            }
            last = nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }

}
