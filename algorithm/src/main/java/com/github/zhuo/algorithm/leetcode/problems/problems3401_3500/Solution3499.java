package com.github.zhuo.algorithm.leetcode.problems.problems3401_3500;

/**
 * 操作后最大活跃区段数 I
 */
public class Solution3499 {

    /**
     * beats 98.59%
     */
    public int maxActiveSectionsAfterTrade(String s) {
        int Max = 0;

        char ch = s.charAt(0);
        int count = 0;
        int last0 = -1;
        int res = 0;

        for (char c: s.toCharArray()) {
            if (c == ch)
                count += 1;
            else {
                if (c == '1') {
                    if (last0 != -1) {
                        Max = Math.max(Max, last0 + count);
                    }
                    last0 = count;
                } else {
                    res += count;
                }
                count = 1;
                ch = c;
            }
        }

        if (ch == '1') {
            res += count;
        } else if (ch == '0' && last0 != -1) {
            Max = Math.max(Max, last0 + count);
        }
        res += Max;

        return res;
    }
}