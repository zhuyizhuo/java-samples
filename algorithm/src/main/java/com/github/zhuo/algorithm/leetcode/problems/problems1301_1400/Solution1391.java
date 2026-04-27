package com.github.zhuo.algorithm.leetcode.problems.problems1301_1400;

public class Solution1391 {

    /**
     * beats 99.34%
     */
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (m == 1 && n == 1) return true;

        int[][][] streets = {
                {},
                {{0, -1}, {0, 1}},      // 1: 左, 右
                {{-1, 0}, {1, 0}},      // 2: 上, 下
                {{0, -1}, {1, 0}},      // 3: 左, 下
                {{0, 1}, {1, 0}},       // 4: 右, 下
                {{0, -1}, {-1, 0}},     // 5: 左, 上
                {{0, 1}, {-1, 0}}       // 6: 右, 上
        };

        int[][] startDirs = streets[grid[0][0]];
        for (int[] startDir : startDirs) {
            if (walk(grid, m, n, startDir[0], startDir[1], streets)) {
                return true;
            }
        }

        return false;
    }

    private boolean walk(int[][] grid, int m, int n, int dx, int dy, int[][][] streets) {
        int x = 0, y = 0;

        while (true) {
            x += dx;
            y += dy;

            if (x < 0 || x >= m || y < 0 || y >= n) return false;

            boolean canConnect = false;
            int[] nextMove = null;

            int[][] currentStreetDirs = streets[grid[x][y]];
            for (int[] dir : currentStreetDirs) {
                if (dir[0] == -dx && dir[1] == -dy) {
                    canConnect = true;
                } else {
                    nextMove = dir;
                }
            }

            if (!canConnect) return false;

            if (x == m - 1 && y == n - 1) return true;

            dx = nextMove[0];
            dy = nextMove[1];

            if (x == 0 && y == 0) return false;
        }
    }
}