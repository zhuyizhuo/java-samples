package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900.problems1856;

/**
 * https://leetcode-cn.com/problems/maximum-subarray-min-product/
 * 子数组最小乘积的最大值
 * 难度 中等
 * 
 * 一个数组的 最小乘积 定义为这个数组中 最小值 乘以 数组的 和 。
 *
 * 比方说，数组 [3,2,5] （最小值是 2）的最小乘积为 2 * (3+2+5) = 2 * 10 = 20 。
 * 给你一个正整数数组 nums ，请你返回 nums 任意 非空子数组 的最小乘积 的 最大值 。由于答案可能很大，请你返回答案对  109 + 7 取余 的结果。
 *
 * 请注意，最小乘积的最大值考虑的是取余操作 之前 的结果。题目保证最小乘积的最大值在 不取余 的情况下可以用 64 位有符号整数 保存。
 *
 * 子数组 定义为一个数组的连续部分。
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^7
 */
public class MaximumSubarrayMinProduct {

    public static void main(String[] args) {
//        System.out.println(maxSumMinProduct(new int[]{1,2,3,2}));
//        System.out.println(maxSumMinProduct(new int[]{2,3,3,1,2}));
//        System.out.println(maxSumMinProduct(new int[]{3,1,5,6,4,2}));
        //25
        System.out.println(maxSumMinProduct(new int[]{1,1,3,2,2,2,1,5,1,5}));
    }

    //子数组最小乘积的最大值
    public static int maxSumMinProduct(int[] nums) {
        int[][] minVal = new int[nums.length][nums.length];
        int[][] sum = new int[nums.length][nums.length];
        long max = 0;
        for (int i = 0; i < nums.length; i++) {
            minVal[i][i] = nums[i];
            sum[i][i] = nums[i];
            max = Math.max(max, minVal[i][i] * sum[i][i]);
        }
        for (int i = 2; i <= nums.length; i++) {
            for (int left = 0; left + i - 1 < nums.length; left++) {
                int right = left + i - 1;
                minVal[left][right] = Math.min(minVal[left][right-1], nums[right]);
                sum[left][right] = sum[left][right-1] + nums[right];
                if ((minVal[left][right] * sum[left][right]) > max){
                    max = minVal[left][right] * sum[left][right];
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                System.out.println(minVal[i][j] + " " + sum[i][j]);
            }
        }
        return (int)(max%1000_000_007);
    }
}
