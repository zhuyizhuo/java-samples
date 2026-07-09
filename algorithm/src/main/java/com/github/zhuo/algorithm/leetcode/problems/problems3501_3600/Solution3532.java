package com.github.zhuo.algorithm.leetcode.problems.problems3501_3600;

/**
 * 针对图的路径存在性查询 I
 */
public class Solution3532 {

    /**
     * beats 97.03%
     */
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] components = new int[n];
        components[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                components[i] = components[i - 1];
            } else {
                components[i] = components[i - 1] + 1;
            }
        }

        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if (components[u] == components[v]) {
                result[i] = true;
            }
        }
        return result;
    }
}