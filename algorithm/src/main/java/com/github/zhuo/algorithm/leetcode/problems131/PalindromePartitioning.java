package com.github.zhuo.algorithm.leetcode.problems131;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/palindrome-partitioning/
 * 分割回文串
 * 难度 中等
 *
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class PalindromePartitioning {

    public static void main(String[] args) {

    }

    /**
     * 回溯 + 动态规划预处理
     * 需研究动态规划 TODO
     */
    public List<List<String>> partition(String s) {
        int length = s.length();
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < length; i++) {
            sb.append(s.charAt(i)).append("#");
        }
        int length1 = sb.length();
        for (int i = 0; i < length1; i++) {
            String temp = centerSpread(sb.toString(), 0, length1);
        }

        return null;
    }

    private String centerSpread(String toString, int i, int length1) {
        int left = i - 1;
        int right = i + 1;
        return null;
    }
}
