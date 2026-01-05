package com.github.zhuo.algorithm.leetcode.problems.problems3801_3900;

import java.util.Arrays;

public class Solution3801 {
    /**
     * beats 100%
     */
    public long minMergeCost(int[][] lists) {
        int n = lists.length;
        int mask = 1 << n;

        int [][] mergedList = new int [mask][];
        mergedList[0] = new int [0];

        for (int i = 1; i < mask ; ++i) {
            int lowbit = (i & -i);
            int idx = Integer.numberOfTrailingZeros(lowbit);
            int pre = i ^ lowbit;
            mergedList[i] = merge(mergedList[pre], lists[idx]);
        }

        int [] len = new int [mask];
        int [] median = new int [mask];
        for (int i = 1; i < mask ; ++i) {
            len[i] = mergedList[i].length;
            int mid = (len[i] - 1) / 2;
            median[i] = mergedList[i][mid];
        }

        long INF = (long)(1e15);
        long [] f = new long[mask];
        Arrays.fill(f, INF);
        for (int i = 0; i < n ; ++i) {
            f[1 << i] = 0;
        }

        for (int i = 1; i < mask ; ++i) {
            if ((i & (i - 1)) == 0) {
                continue;
            }
            int fb = (i & -i);
            for (int sub = (i - 1) & i ; sub > 0 ; sub = (sub - 1) & i) {
                if ((sub & fb) == 0) {
                    continue;
                }
                int left = i ^ sub;
                if (left == 0) {
                    continue;
                }
                long cost = (long)len[sub] + (long)len[left] + (long)Math.abs(median[sub] - median[left]);
                long best = f[sub] + f[left] + cost;
                if (best < f[i]) f[i] = best;
            }
        }
        return f[mask - 1];
    }

    int [] merge (int [] a, int [] b){
        int m = a.length + b.length;
        int [] ret = new int [m];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                ret[k++] = a[i++];
            } else {
                ret[k++] = b[j++];
            }
        }
        while (i < a.length) {
            ret[k++] = a[i++];
        }
        while (j < b.length) {
            ret[k++] = b[j++];
        }
        return ret;
    }
}
