package com.github.zhuo.algorithm.leetcode.problems.problems3501_3600;

/**
 * 不同 XOR 三元组的数目 II
 */
public class Solution3514 {
    /**
     * beats 75.44%
     */
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        boolean[] has2 = new boolean[2048];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                has2[nums[i] ^ nums[j]] = true;
            }
        }
        boolean[] has3 = new boolean[2048];
        for (int x = 0; x < 2048; x++) {
            if (!has2[x]) {
                continue;
            }
            for (int v : nums) {
                has3[x ^ v] = true;
            }
        }
        int ans = 0;
        for (boolean b : has3) {
            if (b) {
                ans++;
            }
        }
        return ans;
    }
}