package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 最大子序和
 */
public class Solution53 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1, 4, -1000}));
    }

    /**
     * beats 100%
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currSum < 0){
                currSum = nums[i];
            } else {
                currSum += nums[i];
            }
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

}
