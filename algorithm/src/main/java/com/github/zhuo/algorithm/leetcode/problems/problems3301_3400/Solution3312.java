package com.github.zhuo.algorithm.leetcode.problems.problems3301_3400;

/**
 * 查询排序后的最大公约数
 * hard
 */
public class Solution3312 {

    /**
     * beats 100%
     */
    public int[] gcdValues(int[] nums, long[] queries) {
        int u = 0;
        for (int x : nums) {
            u = Math.max(u, x);
        }
        int[] cnt = new int[u + 1];
        for (int x : nums) {
            cnt[x]++;
        }

        long[] g = new long[u + 1];
        for (int i = u; i > 0; i--) {
            long s = 0, t = 0;
            for (int j = i; j <= u; j += i) {
                s += cnt[j];
                if (j > i) t += g[j];
            }
            g[i] = s * (s - 1) / 2 - t;
        }
        for (int i = 0; i < u; i++) {
            g[i + 1] += g[i];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = upperBound(g, queries[i]);
        }
        return ans;
    }
    private int upperBound(long[] a, long t) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (a[m] <= t) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
