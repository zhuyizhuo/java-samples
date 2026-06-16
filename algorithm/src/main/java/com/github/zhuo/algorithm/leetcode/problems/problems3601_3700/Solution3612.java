package com.github.zhuo.algorithm.leetcode.problems.problems3601_3700;

/**
 * 用特殊操作处理字符串 I
 */
public class Solution3612 {

    /**
     * beats 100%
     */
    public String processStr(String s) {
        StringBuilder result = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (result.length() > 0) result.deleteCharAt(result.length() - 1);
            } else if (ch == '#') {
                result.append(result.toString());
            } else if (ch == '%') {
                result.reverse();
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}