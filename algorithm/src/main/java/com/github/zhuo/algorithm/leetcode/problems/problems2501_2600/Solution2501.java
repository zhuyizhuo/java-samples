package com.github.zhuo.algorithm.leetcode.problems.problems2501_2600;

public class Solution2501 {
    public int longestSquareStreak(int[] nums) {
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }

        int[] f = new int[mx + 1];
        for (int x : nums)
            f[x] = 1;

        int ans = 1;
        for (int i = 2; i <= mx; i++) {
            if(mx / i < i) break;

            if(f[i] > 0 && f[i * i] == 1){
                f[i * i] += f[i];
                ans = Math.max(ans, f[i * i]);
            }
        }
        return ans > 1 ? ans : -1;
    }
}
