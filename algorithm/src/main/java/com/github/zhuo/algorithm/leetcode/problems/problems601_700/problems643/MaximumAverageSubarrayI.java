package com.github.zhuo.algorithm.leetcode.problems.problems601_700.problems643;

/**
 * https://leetcode-cn.com/problems/maximum-average-subarray-i/
 *
 * 子数组最大平均数 I
 *
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 *
 * 示例：
 * 输入：[1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 */
public class MaximumAverageSubarrayI {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += nums[i];
        }
        int prev = 0;
        int next = prev + k;
        int newSum = max;
        while (next < nums.length){
            newSum = newSum - nums[prev] + nums[next];
            max = Math.max(max, newSum);
            prev++;
            next++;
        }
        return (double)max/k;
    }
}
