package com.github.zhuo.algorithm.leetcode.problems.problems2901_3000;

import java.util.HashMap;

/**
 * 最多 K 个重复元素的最长子数组
 */
public class Solution2958 {
    /**
     * beats 97.99%
     */
    public int maxSubarrayLength(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int right = 0, left = 0; right < nums.length; right++) {
            Integer value = map.merge(nums[right], 1, Integer::sum);
            while (value > k) {
                map.merge(nums[left], -1, Integer::sum);
                if(nums[left] == nums[right]) value--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}