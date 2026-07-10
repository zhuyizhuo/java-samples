package com.github.zhuo.algorithm.leetcode.problems.problems3501_3600;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 针对图的路径存在性查询 II
 * hard
 */
public class Solution3534 {

    /**
     * beats 91.67%
     */
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Integer[] idx = new Integer[n];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, Comparator.comparingInt(a -> nums[a]));

        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[idx[i]] = i;
        }

        int w = 32 - Integer.numberOfLeadingZeros(n);
        int[][] pa = new int[w][n];
        int left = 0;
        for (int i = 0; i < n; i++) {
            while (nums[idx[i]] - nums[idx[left]] > maxDiff) {
                left++;
            }
            pa[0][i] = left;
        }
        for (int i = 0; i < w - 1; i++) {
            for (int x = 0; x < n; x++) {
                int p = pa[i][x];
                pa[i + 1][x] = pa[i][p];
            }
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == r) {
                continue;
            }
            l = rank[l];
            r = rank[r];
            if (l > r) {
                int temp = l;
                l = r;
                r = temp;
            }
            int res = 0;
            for (int k = w - 1; k >= 0; k--) {
                if (pa[k][r] > l) {
                    r = pa[k][r];
                    res |= 1 << k;
                }
            }
            ans[i] = pa[0][r] > l ? -1 : res + 1;
        }
        return ans;
    }
}