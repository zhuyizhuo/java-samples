package com.github.zhuo.algorithm.leetcode.problems.problems1301_1400;

/**
 * 包含所有三种字符的子字符串数目
 *
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 *
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 */
public class Solution1358 {

    /**
     * beats 97.93%
     */
    public int numberOfSubstrings(String s) {
        char[] sc = s.toCharArray();
        int n = sc.length;
        int ans = 0;
        int[] cnt = new int[3];
        for (int i = 0; i < sc.length; i++) {
            cnt[sc[i] - 'a'] = i + 1;
            ans += Math.min(cnt[0], Math.min(cnt[1], cnt[2]));
        }
        return ans;
    }
}