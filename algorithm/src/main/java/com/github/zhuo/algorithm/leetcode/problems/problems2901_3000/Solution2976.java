package com.github.zhuo.algorithm.leetcode.problems.problems2901_3000;

import java.util.Arrays;

/**
 * 转换字符串的最小成本 I
 *
 * 给你两个下标从 0 开始的字符串 source 和 target ，它们的长度均为 n 并且由 小写 英文字母组成。
 *
 * 另给你两个下标从 0 开始的字符数组 original 和 changed ，以及一个整数数组 cost ，其中 cost[i] 代表将字符 original[i] 更改为字符 changed[i] 的成本。
 *
 * 你从字符串 source 开始。在一次操作中，如果 存在 任意 下标 j 满足 cost[j] == z  、original[j] == x 以及 changed[j] == y 。你就可以选择字符串中的一个字符 x 并以 z 的成本将其更改为字符 y 。
 *
 * 返回将字符串 source 转换为字符串 target 所需的 最小 成本。如果不可能完成转换，则返回 -1 。
 *
 * 注意，可能存在下标 i 、j 使得 original[j] == original[i] 且 changed[j] == changed[i] 。
 */
public class Solution2976 {
    /**
     * beats 91.3%
     */
    public long minimumCost(String source, String target, char[] original, char[] changed,
                            int[] cost) {
        final int MAX_VALUE = 1_000_000_000;
        int[][] costs = new int[26][26];
        for (int i = 0; i < 26; i++) {
            Arrays.fill(costs[i], MAX_VALUE);
        }
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            costs[from][to] = Math.min(costs[from][to], cost[i]);
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (costs[i][k] == MAX_VALUE) {
                    continue;
                }
                for (int j = 0; j < 26; j++) {
                    costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                }
            }
        }
        int len = source.length();
        long ans = 0;
        for (int i = 0; i < len; i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if (from != to) {
                if (costs[from][to] == MAX_VALUE) {
                    return -1;
                }
                ans += costs[from][to];
            }
        }
        return ans;
    }
}