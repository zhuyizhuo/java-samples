package com.github.zhuo.algorithm.leetcode.problems.problems2001_2100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2003 {
    /**
     * beats 100%
     */
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        List<Integer>[] children = new ArrayList[n];
        for (int i = 0; i < n; i++) children[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) children[parents[i]].add(i);

        int[] ans = new int[n];
        Arrays.fill(ans, 1);

        int u = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                u = i;
                break;
            }
        }
        if (u == -1) return ans;

        int S = 100000 + 2;
        boolean[] present = new boolean[S + 1];
        boolean[] visited = new boolean[n];

        int mex = 1;
        int curr = u;
        int prev = -2;

        while (curr != -1) {
            for (int y : children[curr]) {
                if (y != prev) addSubtree(y, children, visited, present, nums);
            }
            if (!visited[curr]) {
                visited[curr] = true;
                int val = nums[curr];
                if (val <= S) present[val] = true;
            }
            while (mex <= S && present[mex]) mex++;
            ans[curr] = mex;
            prev = curr;
            curr = parents[curr];
        }

        return ans;
    }

    private void addSubtree(int x, List<Integer>[] children, boolean[] visited, boolean[] present, int[] nums) {
        if (visited[x]) return;
        visited[x] = true;
        int S = present.length - 1;
        int val = nums[x];
        if (val <= S) present[val] = true;
        for (int y : children[x]) addSubtree(y, children, visited, present, nums);
    }
}
