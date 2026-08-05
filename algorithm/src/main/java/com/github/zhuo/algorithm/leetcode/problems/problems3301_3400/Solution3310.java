package com.github.zhuo.algorithm.leetcode.problems.problems3301_3400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 移除可疑的方法
 */
public class Solution3310 {
    /**
     * beats 100%
     */
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        int m = invocations.length;
        int[] head = new int[n], nxt = new int[m];
        Arrays.fill(head, -1);
        for (int i = 0; i < m; ++i) {
            int u = invocations[i][0];
            nxt[i] = head[u];
            head[u] = i;
        }
        int[] q = new int[n];
        boolean[] vis = new boolean[n];
        int s = 0, e = -1;
        vis[q[++e] = k] = true;
        while (s <= e) {
            int u = q[s++];
            for (int i = head[u]; i > -1; i = nxt[i]) {
                int v = invocations[i][1];
                if (!vis[v]) vis[q[++e] = v] = true;
            }
        }
        Arrays.fill(head, -1);
        for (int i = 0; i < m; ++i) {
            int v = invocations[i][1];
            nxt[i] = head[v];
            head[v] = i;
        }
        List<Integer> ans = new ArrayList<>(n);
        for (int v = 0; v < n; ++v) {
            if (!vis[v]) {
                ans.add(v);
                continue;
            }
            for (int i = head[v]; i > -1; i = nxt[i]) {
                int u = invocations[i][0];
                if (!vis[u]) {
                    ans.clear();
                    for (int z = 0; z < n; ++z) ans.add(z);
                    return ans;
                }
            }
        }
        return ans;
    }
}