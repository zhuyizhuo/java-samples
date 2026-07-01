package com.github.zhuo.algorithm.leetcode.problems.problems2801_2900;

import java.util.*;

/***
 * 找出最安全路径
 */
public class Solution2812 {

    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * beats 99.05%
     */
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        // 1. 多源 BFS 计算每个网格到最近小偷的距离
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    dist[r][c] = 0;
                    queue.offer(new int[]{r, c});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];
            for (int[] d : DIRS) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }

        // 2. 使用 Dijkstra 算法（最大堆）寻找最大安全路径
        // 堆中元素格式: [r, c, 从起点到当前位置路径上的最小安全系数]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]); // 按安全系数降序

        // 记录到达每个格子的最大安全系数，初始化为 -1
        int[][] maxSafe = new int[n][n];
        for (int[] row : maxSafe) {
            Arrays.fill(row, -1);
        }

        maxSafe[0][0] = dist[0][0];
        pq.offer(new int[]{0, 0, dist[0][0]});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], safe = curr[2];

            // 第一次到达终点，即为最优解，直接返回
            if (r == n - 1 && c == n - 1) {
                return safe;
            }

            // 剪枝：如果当前路径的安全系数已经小于已知到达该点的更好选择，则跳过
            if (safe < maxSafe[r][c]) {
                continue;
            }

            for (int[] d : DIRS) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    // 移动到新格子后的安全系数，取决于当前路径安全系数和新格子自身安全系数的较小值
                    int nextSafe = Math.min(safe, dist[nr][nc]);
                    // 如果能获得更大的安全系数，则更新并入队
                    if (nextSafe > maxSafe[nr][nc]) {
                        maxSafe[nr][nc] = nextSafe;
                        pq.offer(new int[]{nr, nc, nextSafe});
                    }
                }
            }
        }

        return 0;
    }
}