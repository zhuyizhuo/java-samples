package com.github.zhuo.algorithm.leetcode.problems.problems2401_2500;

/**
 * 两个城市间路径的最小分数
 */
public class Solution2492 {

    private int[] parent;
    private int[] minEdge;  // 每个根节点所在连通分量的最小边权

    /**
     * beats 100%
     */
    public int minScore(int n, int[][] roads) {
        parent = new int[n + 1];
        minEdge = new int[n + 1];
        // 初始化：每个节点自成一派，最小边权初始为无穷大
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            minEdge[i] = Integer.MAX_VALUE;
        }

        // 处理每条边
        for (int[] road : roads) {
            union(road[0], road[1], road[2]);
        }

        // 1 和 n 必然连通，直接返回它们所在集合的最小边权
        return minEdge[find(1)];
    }

    // 查找根节点 + 路径压缩
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // 合并两个集合，并更新整个集合的最小边权
    private void union(int x, int y, int weight) {
        int rootX = find(x);
        int rootY = find(y);

        // 计算新集合的最小边权（两个旧集合的最小值 + 当前边的权值）
        int newMin = Math.min(minEdge[rootX], minEdge[rootY]);
        newMin = Math.min(newMin, weight);

        // 如果已经是同一个集合，只需更新根的最小值
        if (rootX == rootY) {
            minEdge[rootX] = newMin;
            return;
        }

        // 简单合并：直接将 rootX 挂到 rootY 下，更新根的最小值
        parent[rootX] = rootY;
        minEdge[rootY] = newMin;
    }
}