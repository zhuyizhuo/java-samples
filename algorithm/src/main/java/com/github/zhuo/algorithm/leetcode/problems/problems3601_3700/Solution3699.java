package com.github.zhuo.algorithm.leetcode.problems.problems3601_3700;

/**
 * 锯齿形数组的总数 I
 * hard
 */
public class Solution3699 {

    /**
     * beats 100%
     */
    public int zigZagArrays(int n, int l, int r) {
        final int MOD = 1_000_000_007;
        int m = r - l + 1;
        int[] a = new int[m], b = new int[m];

        for (int v = 1; v < m; v++) a[v] = v;

        for (int i = 2; i < n; i++) {
            int s = 0;
            b[0] = 0;
            for (int v = 1; v < m; v++) {
                s += a[m - v] - MOD;   // 先减 MOD，使结果可能为负
                s += MOD & (s >> 31);   // 若为负则加回 MOD（算术右移取符号位）
                b[v] = s;
            }
            int[] t = a; a = b; b = t;
        }

        int ans = 0;
        for (int v = 0; v < m; v++) {
            ans += a[v] - MOD;
            ans += MOD & (ans >> 31);
        }
        ans <<= 1;
        ans -= MOD & ~((ans - MOD) >> 31);
        return ans;
    }
}