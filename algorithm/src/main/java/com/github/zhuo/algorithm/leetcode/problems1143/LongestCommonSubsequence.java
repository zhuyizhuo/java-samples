package com.github.zhuo.algorithm.leetcode.problems1143;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * 最长公共子序列
 * 难度 中等
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * 提示：
 *
 * 1 <= text1.length, text2.length <= 1000
 * text1 和 text2 仅由小写英文字符组成。
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }

    /**
     * 思路：看到最长的子序列 就想到动态规划
     * 求A、B两个字符串的公共子序列的最长长度，可先求A{0,n-1},B{0,k-1}的公共子序列的最长长度
     *  如果 A[i] = B[j] 则 DP[i][j] = DP[i+1][j+1] + 1，
     *  如果 A[i] ≠ B[j] 则 DP[j][j] = MAX(DP[i+1][j], DP[i][j+1])
     *  由于动归需要开始条件，可在字符串末位加上空字符串，空字符的公共序列数都是0
     *
     * 执行用时： 12 ms , 在所有 Java 提交中击败了 79.02% 的用户
     * 内存消耗： 42.2 MB , 在所有 Java 提交中击败了 63.49% 的用户
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int length = text1.length();
        int length1 = text2.length();
        int[][] counts = new int[length + 1][length1 + 1];
        for (int i = length - 1; i >= 0; i--) {
            for (int j = length1 - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)){
                    counts[i][j] = counts[i+1][j+1] + 1;
                } else {
                    counts[i][j] = Math.max(counts[i+1][j], counts[i][j+1]);
                }
            }
        }
        return counts[0][0];
    }

}
