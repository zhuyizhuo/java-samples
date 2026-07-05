package com.github.zhuo.algorithm.leetcode.problems.problems1301_1400;

import java.util.Arrays;
import java.util.List;

/**
 * 最大得分的路径数目
 * hard
 */
public class Solution1301 {

    static int MOD = (int)1e9 + 7;
    int[][] memo;
    int[][] memo2;
    int m;

    /**
     * beats 100%
     */
    public int[] pathsWithMaxScore(List<String> board) {
        m = board.size();
        memo = new int[m][m];
        memo2 = new int[m][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        for (int[] row : memo2)
            Arrays.fill(row, -1);

        memo[0][0] = 0;
        int max = dfs(board, m - 1, m - 1);
        if (max < 0)
            return new int[2];

        int num = dfs2(board, m - 1, m - 1, max);
        return new int[]{max, num};
    }

    int dfs(List<String> board, int x, int y) {
        if (x == 0 && y == 0)
            return 0;

        if (memo[x][y] != -1)
            return memo[x][y];

        int res = Integer.MIN_VALUE;
        char c = board.get(x).charAt(y);
        int cur = c == 'S' ? 0 : c - '0';
        if (x > 0 && board.get(x - 1).charAt(y) != 'X')
            res = Math.max(res, dfs(board, x - 1, y) + cur);
        if (y > 0 && board.get(x).charAt(y - 1) != 'X')
            res = Math.max(res, dfs(board, x, y - 1) + cur);
        if (x > 0 && y > 0 && board.get(x - 1).charAt(y - 1) != 'X') {
            res = Math.max(res, dfs(board, x - 1, y - 1) + cur);
        }

        return memo[x][y] = res;
    }

    int dfs2(List<String> board, int x, int y, int score) {
        if (x == 0 && y == 0)
            return 1;

        if (memo2[x][y] != -1)
            return memo2[x][y];

        int res = 0;
        char c = board.get(x).charAt(y);
        int cur = c == 'S' ? 0 : c - '0';
        if (x > 0 && board.get(x - 1).charAt(y) != 'X' && score == memo[x - 1][y] + cur)
            res = (res + dfs2(board, x - 1, y, score - cur)) % MOD;
        if (y > 0 && board.get(x).charAt(y - 1) != 'X' && score == memo[x][y - 1] + cur)
            res = (res + dfs2(board, x, y - 1, score - cur)) % MOD;
        if (x > 0 && y > 0 && board.get(x - 1).charAt(y - 1) != 'X' && score == memo[x - 1][y - 1] + cur) {
            res = (res + dfs2(board, x - 1, y - 1, score - cur)) % MOD;
        }

        // System.out.println("x:" + x + " y:" + y + " s:" + score + " val:" + res);
        return memo2[x][y] = res;
    }
}