package com.github.zhuo.algorithm.leetcode.problems.problems3701_3800;

import java.util.HashSet;
import java.util.Set;

/**
 * 缺失的最小倍数
 * easy
 */
public class Solution3718 {
    /**
     * beats 75.22%
     */
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }
        int ans = k;
        while (seen.contains(ans)) {
            ans += k;
        }
        return ans;
    }
}
