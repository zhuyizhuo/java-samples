package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems5;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 *
 *  Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * Example 3:
 * Input: s = "a"
 * Output: "a"
 *
 * Example 4:
 * Input: s = "ac"
 * Output: "a"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters (lower-case and/or upper-case),
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String str = "ac";
        System.out.println("给定的字符串: "+ str + ",最长的回文串: " + longestPalindrome(str));
    }

    /**
     * 返回给定字符串中最长的回文串
     * 普通解法 时间复杂度 O(n^2) 空间复杂度 O(n)
     * @param s 给定的字符串
     * @return 给定的字符串中最长的回文串
     */
    public static String longestPalindrome(String s) {
        int sLen = s.length();
        if (sLen == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < sLen; i++) {
            sb.append(s.charAt(i))
                    .append("#");
        }
        int length = sb.length();
        String newStr = sb.toString();
        int maxLen = 1;
        int start = 0;
        for (int i = 0; i < length; i++) {
            int currLen = centerSpread(newStr, length, i);
            if (currLen > maxLen){
                maxLen = currLen;
                start = (i - maxLen)/2;
            }
        }
        return s.substring(start, start + maxLen);
    }

    private static int centerSpread(String newStr, int length, int center) {
        int leftIndex = center - 1;
        int rightIndex = center + 1;
        int step = 0;
        while (leftIndex >= 0 && rightIndex < length && newStr.charAt(leftIndex) == newStr.charAt(rightIndex)){
            leftIndex--;
            rightIndex++;
            step++;
        }
        return step;
    }
}
