package com.github.zhuo.algorithm.leetcode.problems.problems701_800;

/**
 * 给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。
 */
public class Solution712 {
    /**
     * beats 100%
     */
    public int minimumDeleteSum(String s11, String s22) {
        char[] s1 = s11.toCharArray();
        char[] s2 = s22.toCharArray();
        int m = s1.length, n = s2.length, sum = 0;
        for (char x : s2) sum += x;
        int[] f = new int[n + 1];
        for (int i = 0; i < m; i++) {
            sum += s1[i];
            int prev = 0;
            for (int j = 0; j < n; j++) {
                int tmp = f[j + 1];
                if (s1[i] == s2[j]) {
                    f[j + 1] = prev + s2[j];
                } else {
                    f[j + 1] = Math.max(f[j], f[j + 1]);
                }
                prev = tmp;
            }
        }
        return sum - 2 * f[n];
    }
}