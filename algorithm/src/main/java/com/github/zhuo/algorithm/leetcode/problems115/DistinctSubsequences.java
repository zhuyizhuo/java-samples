package com.github.zhuo.algorithm.leetcode.problems115;

/**
 * https://leetcode-cn.com/problems/distinct-subsequences/
 * 不同的子序列
 * 难度 困难
 *
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 * 提示：
 *
 * 0 <= s.length, t.length <= 1000
 * s 和 t 由英文字母组成
 */
public class DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(numDistinct("babgbag", "bag"));
    }

    /**
     * 动态规划
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 92.49% 的用户
     * 内存消耗： 37 MB , 在所有 Java 提交中击败了 11.22% 的用户
     */
    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n){
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m-1; i >= 0; i--) {
            char c = s.charAt(i);
            for (int j = n-1; j >= 0; j--) {
                char c1 = t.charAt(j);
                //当子串的字符等于搜索串的字符时 可选择自身匹配 也可选择与之后的匹配
                if (c == c1){
                    dp[i][j] = dp[i+1][j+1] + dp[i+1][j];
                } else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}
