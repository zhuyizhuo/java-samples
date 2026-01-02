package com.github.zhuo.algorithm.leetcode.problems.problems901_1000;

public class Solution961 {
    /**
     * beats 100%
     */
    public int repeatedNTimes(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x == nums[i-1] ||
                    (i>1 && x==nums[i-2]) ||
                    (i>2 && x==nums[i-3])) return x;
        }
        return -1;
    }
}