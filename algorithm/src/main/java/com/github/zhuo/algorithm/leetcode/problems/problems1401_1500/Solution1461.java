package com.github.zhuo.algorithm.leetcode.problems.problems1401_1500;

/**
 * 检查一个字符串是否包含所有长度为 K 的二进制子串
 *
 * 给你一个二进制字符串 s 和一个整数 k 。如果所有长度为 k 的二进制字符串都是 s 的子串，请返回 true ，否则请返回 false 。
 */
public class Solution1461 {

    /**
     * beats 98.52%
     */
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        if (need > s.length()) return false;

        boolean[] seen = new boolean[need];
        int mask = need - 1;
        int hash = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            hash = ((hash << 1) & mask) | (s.charAt(i) - '0');

            if (i >= k - 1 && !seen[hash]) {
                seen[hash] = true;
                count++;
                if (count == need) return true;
            }
        }

        return false;
    }
}