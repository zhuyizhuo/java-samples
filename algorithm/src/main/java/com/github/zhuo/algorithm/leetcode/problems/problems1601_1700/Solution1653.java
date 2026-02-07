package com.github.zhuo.algorithm.leetcode.problems.problems1601_1700;

/**
 * 使字符串平衡的最少删除次数
 *
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b' 。
 *
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。
 *
 * 请你返回使 s 平衡 的 最少 删除次数。
 */
public class Solution1653 {
    /**
     * beats 100%
     */
    public int minimumDeletions(String S) {

        char[] s = S.toCharArray();

        int del = 0;

        for (char c : s) {

            del += 'b' - c; // 统计 'a' 的个数

        }

        int ans = del;

        for (char c : s) {

            // 'a' -> -1    'b' -> 1

            del += (c - 'a') * 2 - 1;

            ans = Math.min(ans, del);

        }

        return ans;

    }

}