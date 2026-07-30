package com.github.zhuo.algorithm.leetcode.problems.problems3001_3100;

/**
 * 输入单词需要的最少按键次数 I
 */
public class Solution3014 {

    /**
     * beats 100%
     */
    public int minimumPushes(String word) {
        int n = word.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += i / 8 + 1;
        }
        return ans;
    }
}