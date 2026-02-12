package com.github.zhuo.algorithm.leetcode.problems.problems3701_3800;

/**
 * 最长的平衡子串 I
 *
 * 给你一个由小写英文字母组成的字符串 s。
 *
 * 如果一个 子串 中所有 不同 字符出现的次数都 相同 ，则称该子串为 平衡 子串。
 *
 * 请返回 s 的 最长平衡子串 的 长度 。
 *
 * 子串 是字符串中连续的、非空 的字符序列。
 */
public class Solution3713 {

    /**
     * beats 99.81%
     */
    public int longestBalanced(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int res = 1;
        for (int i = 0; i < len; i++) {
            if (len - i == res) {
                // 无更长串
                break;
            }
            int[] count = new int[26];
            int maxCount = 0;
            int numCount = 0;
            for (int j = i; j < len; j++) {
                char c = chars[j];
                if (count[c - 'a'] == 0) {
                    // 新增数字
                    numCount++;
                }
                maxCount = Math.max(maxCount, ++count[c - 'a']);
                int curLen = j - i + 1;
                if (maxCount * numCount == curLen) {
                    res = Math.max(res, curLen);
                }
            }
        }
        return res;
    }
}
