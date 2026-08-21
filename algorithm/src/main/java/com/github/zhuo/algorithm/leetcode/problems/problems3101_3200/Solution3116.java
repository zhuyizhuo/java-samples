package com.github.zhuo.algorithm.leetcode.problems.problems3101_3200;

/**
 * 单面值组合的第 K 小金额
 * h
 */
public class Solution3116 {

    private int k;
    private long[] subsetLcm;

    /**
     * beats 100%
     */
    public long findKthSmallest(int[] coins, int k) {
        this.k = k;
        int n = coins.length;
        subsetLcm = new long[1 << n];
        subsetLcm[0] = 1;
        for (int i = 0; i < n; i++) {
            int lb = 1 << i;
            for (int j = 0; j < lb; j++) {
                subsetLcm[j | lb] = lcm(subsetLcm[j], coins[i]);
            }
        }

        int mn = Integer.MAX_VALUE;
        for (int x : coins) {
            mn = Math.min(mn, x);
        }
        long left = k;
        long right = (long) mn * k;
        while (left <= right) {
            long mid = (right - left) / 2 + left;
            if (check(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(long x) {
        long cnt = 0;
        for (int i = 1; i < subsetLcm.length; i++) {
            cnt += (Integer.bitCount(i) & 1) > 0 ? x / subsetLcm[i] : -x / subsetLcm[i];
        }
        return cnt >= k;
    }

    private long gcd(long a, long b) {
        while (a != 0) {
            long temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}