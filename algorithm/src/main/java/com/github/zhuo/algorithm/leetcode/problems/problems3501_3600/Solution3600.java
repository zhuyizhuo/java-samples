package com.github.zhuo.algorithm.leetcode.problems.problems3501_3600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 升级后最大生成树稳定性
 * hard
 *
 * 给你一个整数 n，表示编号从 0 到 n - 1 的 n 个节点，以及一个 edges 列表，其中 edges[i] = [ui, vi, si, musti]：
 *
 * ui 和 vi 表示节点 ui 和 vi 之间的一条无向边。
 * si 是该边的强度。
 * musti 是一个整数（0 或 1）。如果 musti == 1，则该边 必须 包含在生成树中，且 不能升级 。
 * 你还有一个整数 k，表示你可以执行的最多 升级 次数。每次升级会使边的强度 翻倍 ，且每条可升级边（即 musti == 0）最多只能升级一次。
 *
 * 一个生成树的 稳定性 定义为其中所有边的 最小 强度。
 *
 * 返回任何有效生成树可能达到的 最大 稳定性。如果无法连接所有节点，返回 -1。
 *
 * 注意： 图的一个 生成树（spanning tree）是该图中边的一个子集，它满足以下条件：
 *
 * 将所有节点连接在一起（即图是 连通的 ）。
 * 不 形成任何环。
 * 包含 恰好 n - 1 条边，其中 n 是图中节点的数量。
 */
public class Solution3600 {

    /**
     * beats 97.92%
     */
    public int maxStability(int n, int[][] edges, int k) {
        int m = edges.length;
        if (m < n - 1)
            return -1;
        // 初始化并查集
        UnionFind uf = new UnionFind(n);
        List<int[]> candEdge = new ArrayList<>();
        int mn = Integer.MAX_VALUE;
        int cnt = 0;
        for (int[] edge : edges)
        {
            if(edge[3] == 1)
            {
                int u = edge[0], v = edge[1];
                if (uf.isSame(u, v)) return -1;
                uf.merge(edge[0], edge[1]);
                mn = Math.min(mn, edge[2]);
                cnt++;
            } else {
                candEdge.add(edge);
            }
        }
        candEdge.sort((int[] arr1, int[] arr2) -> {
            return arr2[2]  - arr1[2];
        });
        for (int[] edge: candEdge)
        {
            if (cnt == n - 1) break;
            int u = edge[0], v = edge[1];
            if (uf.isSame(u, v))
                continue;
            uf.merge(u, v);
            int dis = edge[2];
            if (n - 1 - cnt <= k)
                dis *= 2;
            cnt++;
            mn = Math.min(mn, dis);
        }
        return (cnt == n - 1) ? mn : -1;
    }
}
class UnionFind {
    private int[] fa;
    private int[] size;
    public UnionFind(int n)
    {
        this.fa = new int[n];
        for (int i = 0; i < n; ++i) fa[i] = i;
        this.size = new int[n];
        Arrays.fill(this.size, 1);
    }
    // 查 + 路径压缩
    public int find(int x)
    {
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }
    // 判断两个元素是否在同一个集合中
    public boolean isSame(int x, int y)
    {
        return find(x) == find(y);
    }
    // 合并两个不同集合
    public void merge(int from, int to)
    {
        from = find(from);
        to = find(to);
        if (from == to) return;
        fa[from] = to;
        size[to] += size[from];
    }
}
