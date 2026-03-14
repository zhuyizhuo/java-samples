package com.github.zhuo.algorithm.leetcode.problems.problems3801_3900;

/**
 * 划分二进制字符串的最小费用
 * hard
 *
 * 给你一个二进制字符串 s 和两个整数 encCost 与 flatCost。
 *
 * 对于每个下标 i，s[i] = '1' 表示第 i 个元素是敏感的，而 s[i] = '0' 表示它不是敏感的。
 *
 * 该字符串必须被划分为 分段。最初，整个字符串形成一个单一的分段。
 *
 * 对于一个长度为 L 且包含 X 个敏感元素的分段:
 *
 * 如果 X = 0，费用为 flatCost。
 * 如果 X > 0，费用为 L * X * encCost。
 * 如果一个分段具有 偶数长度，你可以将其拆分为两个长度 相等 的 连续分段，此次拆分的费用是所得分段的 费用之和。
 *
 * 返回一个整数，表示所有有效划分中的 最小可能总费用。
 */
public class Solution3864 {

    /**
     * beats 100%
     */
    public long minCost(String s, int encCost, int flatCost) {

        int n = s.length();
        byte[] cs = new byte[n];
        s.getBytes(0, n, cs, 0);

        int[] prefixSum = new int[n + 1];
        int sum = 0;
        for(int i = 0; i < n; ++i){
            sum += cs[i] - '0';
            prefixSum[i + 1] = sum;
        }

        return dfs(0, n, encCost, flatCost, prefixSum);
    }

    long dfs(int left, int right, int encCost, int flatCost, int[] prefixSum){

        int len = right - left;
        int x = prefixSum[right] - prefixSum[left];
        long result = x > 0? (long) len * x * encCost: flatCost;
        if(len % 2 == 0 && x > 0){
            int mid = left + right >> 1;
            result = Math.min(result, dfs(left, mid, encCost, flatCost, prefixSum) + dfs(mid, right, encCost, flatCost, prefixSum));
        }

        return result;
    }
}