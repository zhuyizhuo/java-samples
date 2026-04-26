package com.github.zhuo.algorithm.leetcode.problems.problems1501_1600;

/**
 * 二维网格图中探测环
 *
 * 给你一个二维字符网格数组 grid ，大小为 m x n ，你需要检查 grid 中是否存在 相同值 形成的环。
 *
 * 一个环是一条开始和结束于同一个格子的长度 大于等于 4 的路径。对于一个给定的格子，你可以移动到它上、下、左、右四个方向相邻的格子之一，可以移动的前提是这两个格子有 相同的值 。
 *
 * 同时，你也不能回到上一次移动时所在的格子。比方说，环  (1, 1) -> (1, 2) -> (1, 1) 是不合法的，因为从 (1, 2) 移动到 (1, 1) 回到了上一次移动时的格子。
 *
 * 如果 grid 中有相同值形成的环，请你返回 true ，否则返回 false 。
 *
 */
public class Solution1559 {
    // 并查集检测环：遍历格子只往右/下合并，若已连通则存在环
    int[] parent, rank;

    int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    boolean union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return false; // 已连通，形成环
        if (rank[ra] < rank[rb]) { int t = ra; ra = rb; rb = t; }
        parent[rb] = ra;
        if (rank[ra] == rank[rb]) rank[ra]++;
        return true;
    }

    /**
     * beats 100%
     */
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        parent = new int[m * n];
        rank = new int[m * n];
        for (int i = 0; i < m * n; i++) parent[i] = i;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 向右合并
                if (j + 1 < n && grid[i][j] == grid[i][j + 1]) {
                    if (!union(i * n + j, i * n + j + 1)) return true;
                }
                // 向下合并
                if (i + 1 < m && grid[i][j] == grid[i + 1][j]) {
                    if (!union(i * n + j, (i + 1) * n + j)) return true;
                }
            }
        }
        return false;
    }
}