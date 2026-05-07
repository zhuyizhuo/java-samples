package com.github.zhuo.algorithm.leetcode.problems.problems3601_3700;

/**
 * 跳跃游戏 IX
 *
 * 给你一个整数数组 nums。
 *
 * 从任意下标 i 出发，你可以根据以下规则跳跃到另一个下标 j：
 *
 * 仅当 nums[j] < nums[i] 时，才允许跳跃到下标 j，其中 j > i。
 * 仅当 nums[j] > nums[i] 时，才允许跳跃到下标 j，其中 j < i。
 * 对于每个下标 i，找出从 i 出发且可以跳跃 任意 次，能够到达 nums 中的 最大值 是多少。
 *
 * 返回一个数组 ans，其中 ans[i] 是从下标 i 出发可以到达的最大值。
 */
public class Solution3660 {

    /**
     * beats 100%
     */
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n];
        sum[0] = nums[0];
        for(int i = 1; i < n; i++){
            sum[i] = Math.max(sum[i - 1], nums[i]);
        }
        int mn = nums[n - 1];
        int mx = sum[n - 1];
        for(int j = n - 1; j >= 0; j--){
            if(sum[j] > mn){
                sum[j] = mx;
            }
            else{
                mx = sum[j];
            }
            mn = Math.min(mn, nums[j]);
        }
        return sum;
    }
}