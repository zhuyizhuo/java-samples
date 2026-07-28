package com.github.zhuo.algorithm.leetcode.problems.problems3501_3600;

/**
 * 最小回文排列 I
 */
public class Solution3517 {
    /**
     * beats 100%
     */
    public String smallestPalindrome(String s) {
        int partition = s.length() / 2;
        int[] bucket = new int[26];

        for (int i = 0; i < partition; i++) {
            bucket[s.charAt(i) - 'a'] += 1;
        }

        StringBuilder left = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (bucket[i] > 0) {
                left.append(String.valueOf((char) (i + 'a')).repeat(bucket[i]));
            }
        }

        String mid = s.length() % 2 != 0 ? String.valueOf(s.charAt(partition)) : "";
        String right = new StringBuilder(left).reverse().toString();

        return left.toString() + mid + right;
    }
}