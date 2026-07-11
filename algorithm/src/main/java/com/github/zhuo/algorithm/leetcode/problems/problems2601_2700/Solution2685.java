package com.github.zhuo.algorithm.leetcode.problems.problems2601_2700;

/**
 * 统计完全连通分量的数量
 */
public class Solution2685 {

    /**
     * beats 98.52%
     */
    public int countCompleteComponents(int n, int[][] edges) {
        // 用并查集构建连通分量，同时记每个连通分量的节点数
        // 用数组记录节点有多少邻居，可以只记数字 key = point, value = 邻居数
        // 用数组记录连通分量中有多少节点完全连通 key = parent point, value = 是否完全连通节点数，如果有一个不满足，直接置-1，后续不判断
        UnionFind uf = new UnionFind(n);
        int[] neighborhoodCnts = new int[n];
        for (int i = 0; i < edges.length; i++) {
            uf.combine(edges[i][0], edges[i][1]);
            neighborhoodCnts[edges[i][0]]++;
            neighborhoodCnts[edges[i][1]]++;
        }
        int[] allConnectedChildSize = new int[n+1];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int parent = uf.findParent(i);
            if (allConnectedChildSize[parent] == -1) {
                continue;
            }
            int expectedSize = uf.size[parent];
            if (neighborhoodCnts[i] == expectedSize - 1) {
                allConnectedChildSize[parent]++;
            } else {
                allConnectedChildSize[parent] = -1;
            }
            if (allConnectedChildSize[parent] == expectedSize) {
                ans++;
            }
        }
        return ans;
    }

    static class UnionFind {
        int[] parent;
        int[] size;

        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int findParent(int a) {
            if (parent[a] == a) {
                return a;
            }
            int p = findParent(parent[a]);
            parent[a] = p;
            return p;
        }

        void combine(int a, int b) {
            int ap = findParent(a);
            int bp = findParent(b);
            if (ap == bp) {
                return;
            }
            if (size[ap] > size[bp]){
                size[ap] += size[bp];
                parent[bp] = ap;
            } else {
                size[bp] += size[ap];
                parent[ap] = bp;
            }
        }
    }

}