package com.github.zhuo.algorithm.leetcode.problems.problems1601_1700;

/**
 * 十-二进制数的最少数目
 *
 * 如果一个十进制数字不含任何前导零，且每一位上的数字不是 0 就是 1 ，那么该数字就是一个 十-二进制数 。例如，101 和 1100 都是 十-二进制数，而 112 和 3001 不是。
 *
 * 给你一个表示十进制整数的字符串 n ，返回和为 n 的 十-二进制数 的最少数目。
 */
public class Solution1689 {

    /**
     * beats 96.1%
     */
    public int minPartitions(String n) {
        int ans = 0;
        char t = '0';
        for(char c:n.toCharArray()){
            if(c>t) {
                t = c;
                ans = t - '0';
            }
        }
        return ans;
    }
}