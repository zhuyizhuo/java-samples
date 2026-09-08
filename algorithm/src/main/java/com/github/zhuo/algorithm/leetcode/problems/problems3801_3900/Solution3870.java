package com.github.zhuo.algorithm.leetcode.problems.problems3801_3900;

/**
 * 统计范围内的逗号
 * easy
 */
public class Solution3870 {
    /**
     * beats 100%
     */
    public int countCommas(int n) {
        return n < 1000 ? 0 : n - 999;
    }
}
