package com.github.zhuo.algorithm.leetcode.problems.problems3001_3100;

/**
 * 每个字符最多出现两次的最长子字符串
 * easy
 */
public class Solution3090 {
    /**
     * beats 100%
     */
    public int maximumLengthSubstring(String s) {
        int[] count = new int[26];
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            count[c - 'a']++;

            while (count[c - 'a'] > 2) {
                char leftChar = s.charAt(left);
                count[leftChar - 'a']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}