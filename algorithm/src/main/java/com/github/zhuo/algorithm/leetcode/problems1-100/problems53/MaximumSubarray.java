package com.github.zhuo.algorithm.leetcode.problems53;

/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 *
 * 最大子序和
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        //todo 考虑使用  动态规划 分治 解该题
        System.out.println(maxSubArray(new int[]{-1, 4, -1000}));
    }

    /**
     * 贪心算法
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
