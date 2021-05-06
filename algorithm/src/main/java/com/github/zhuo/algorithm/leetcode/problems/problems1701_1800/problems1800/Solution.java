package com.github.zhuo.algorithm.leetcode.problems.problems1701_1800.problems1800;

/**
 * https://leetcode-cn.com/problems/maximum-ascending-subarray-sum/
 * 最大升序子数组和
 * 难度 简单
 *
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 *
 * 子数组是数组中的一个连续数字序列。
 *
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi < numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
 *
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10,20,30,5,10,50}));
        System.out.println(maxAscendingSum(new int[]{10,20,30,40,50}));
        System.out.println(maxAscendingSum(new int[]{12,17,15,13,10,11,12}));
        System.out.println(maxAscendingSum(new int[]{100,10,1}));
        System.out.println(maxAscendingSum(new int[]{100}));
    }


    /**
     * 执行用时: 0 ms
     * 内存消耗: 35.9 MB
     */
    public static int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]){
                curr += nums[i];
                max = Math.max(curr, max);
            } else {
                curr = nums[i];
            }
        }
        return max;
    }

}
