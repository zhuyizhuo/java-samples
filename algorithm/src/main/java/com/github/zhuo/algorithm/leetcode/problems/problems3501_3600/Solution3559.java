package com.github.zhuo.algorithm.leetcode.problems.problems3501_3600;

/**
 * 给边赋权值的方案数 II
 * hard
 */
public class Solution3559 {

    private static final int MAXN = (int) 1e5 + 10, MOD = (int) 1e9 + 7;

    private static int[] h = new int[MAXN], e = new int[MAXN << 1], ne = new int[MAXN << 1], d = new int[MAXN];

    private static int n, idx;

    private int[][] fa;

    private static void add(int u, int v) {
        e[idx] = v;
        ne[idx] = h[u];
        h[u] = idx++;
    }

    private void dfs(int u, int from) {
        if (from != -1) {
            d[u] = d[from] + 1;
            fa[u][0] = from;
            for (int i = 1; 1 << i <= d[u]; i++) {
                fa[u][i] = fa[fa[u][i - 1]][i - 1];
            }
        }

        for (int i = h[u]; i != -1; i = ne[i]) {
            int v = e[i];
            if (v == from) continue;
            dfs(v, u);
        }
    }

    private int lca(int u, int v) {
        if (d[v] > d[u]) {
            int t = u;
            u = v;
            v = t;
        }

        int dis = d[u] - d[v];
        while (dis > 0) {
            int k = Integer.numberOfTrailingZeros(dis);
            u = fa[u][k];
            dis = dis & dis - 1;
        }

        if (u == v) {
            return u;
        }

        int hi = 32 - Integer.numberOfLeadingZeros(d[u]);
        for (int i = hi - 1; i >= 0; i--) {
            if (fa[u][i] != fa[v][i]) {
                u = fa[u][i];
                v = fa[v][i];
            }
        }

        return fa[u][0];
    }

    /**
     * beats 95.65%
     */
    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        idx = 0;
        int m = edges.length;
        n = m + 1;
        fa = new int[n + 1][32 - Integer.numberOfLeadingZeros(m)];
        for (int i = 1; i <= n; i++) {
            h[i] = -1;
            d[i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            add(u, v);
            add(v, u);
        }

        dfs(1, -1);

        long[][] f = new long[m + 1][2];
        for (int i = 1; i <= m; i++) {
            f[i][0] = (f[i - 1][0] + f[i - 1][1]) % MOD;
            f[i][1] = (f[i - 1][1] + f[i - 1][0] + 1) % MOD;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            if (u == v) continue;
            int k = d[u] + d[v] - 2 * d[lca(u, v)];
            ans[i] = (int) f[k][1];
        }
        return ans;
    }
}