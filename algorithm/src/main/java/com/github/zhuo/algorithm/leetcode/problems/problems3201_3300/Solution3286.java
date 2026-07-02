package com.github.zhuo.algorithm.leetcode.problems.problems3201_3300;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 穿越网格图的安全路径
 */
public class Solution3286 {

    /**
     * beats 97.13%
     */
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        int[][] newGrid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newGrid[i][j] = grid.get(i).get(j);
            }
        }

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        //q中保存当前节点的x坐标, y坐标 从[0,0]到当前节点剩余的健康值
        Deque<int[]> q = new ArrayDeque<>();
        q.offerFirst(new int[]{0, 0});

        // 从[0,0]到当前节点的最大健康值
        int[][] dis = new int[m][n];
        for (int[] x : dis) {
            Arrays.fill(x, Integer.MAX_VALUE);
        }
        dis[0][0] = newGrid[0][0];

        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int curX = cur[0];
            int curY = cur[1];
            if (dis[curX][curY] >= health) {
                return false;
            }
            if (curX == m - 1 && curY == n - 1) {
                return true;
            }
            for (int[] dir : dirs) {
                int x = curX + dir[0];
                int y = curY + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }
                int cost = newGrid[x][y];
                if (dis[curX][curY] + cost < dis[x][y]) {
                    dis[x][y] = dis[curX][curY] + cost;
                    if (cost == 0) {
                        q.addFirst(new int[]{x, y});
                    } else {
                        q.addLast(new int[]{x, y});
                    }
                }
            }
        }
        return false;
    }
}