package com.github.zhuo.algorithm.leetcode.problems.problems3601_3700;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 区间乘法查询后的异或 II
 * hard
 *
 */
public class Solution3655 {
    private static final int MOD = 1_000_000_007;

    /**
     * beats 100%
     */
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int B = (int) Math.sqrt(queries.length);
        List<int[]>[] groups = new ArrayList[B];
        Arrays.setAll(groups, i -> new ArrayList<>());

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            if (k < B) {
                groups[k].add(new int[]{l, r, v});
            } else {
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int) ((long) nums[i] * v % MOD);
                }
            }
        }

        int[] diff = new int[n + 1];
        for (int k = 1; k < B; k++) {
            List<int[]> g = groups[k];
            if (g.isEmpty()) {
                continue;
            }

            List<int[]>[] buckets = new ArrayList[k];
            Arrays.setAll(buckets, i -> new ArrayList<>());
            for (int[] t : g) {
                buckets[t[0] % k].add(t);
            }

            for (int start = 0; start < k; start++) {
                List<int[]> bucket = buckets[start];
                if (bucket.isEmpty()) {
                    continue;
                }
                if (bucket.size() == 1) {
                    // 只有一个询问，直接暴力
                    int[] t = bucket.get(0);
                    int l = t[0], r = t[1];
                    long v = t[2];
                    for (int i = l; i <= r; i += k) {
                        nums[i] = (int) (nums[i] * v % MOD);
                    }
                    continue;
                }

                int m = (n - start - 1) / k + 1;
                Arrays.fill(diff, 0, m, 1);
                for (int[] t : bucket) {
                    int l = t[0];
                    long v = t[2];
                    diff[l / k] = (int) (diff[l / k] * v % MOD);
                    int r = (t[1] - start) / k + 1;
                    diff[r] = (int) (diff[r] * pow(v, MOD - 2) % MOD);
                }

                long mulD = 1;
                for (int i = 0; i < m; i++) {
                    mulD = mulD * diff[i] % MOD;
                    int j = start + i * k;
                    nums[j] = (int) (nums[j] * mulD % MOD);
                }
            }
        }

        int ans = 0;
        for (int x : nums) {
            ans ^= x;
        }
        return ans;
    }

    private long pow(long x, int n) {
        long res = 1;
        for (; n > 0; n /= 2) {
            if (n % 2 > 0) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
        }
        return res;
    }
}