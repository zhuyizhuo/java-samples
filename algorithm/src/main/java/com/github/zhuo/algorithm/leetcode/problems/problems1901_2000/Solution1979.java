package com.github.zhuo.algorithm.leetcode.problems.problems1901_2000;

/**
 * 找出数组的最大公约数
 * easy
 */
public class Solution1979 {

    /**
     * beats 100%
     */
    public int findGCD(int[] nums) {
        int minVal = Integer.MAX_VALUE;
        int maxVal = 0;
        for (int val : nums) {
            minVal = Math.min(minVal, val);
            maxVal = Math.max(maxVal, val);
        }
        int tmp = 0;
        while (minVal != 0) {
            tmp = minVal;
            minVal = maxVal % minVal;
            maxVal = tmp;
        }
        return maxVal;
    }
}