package com.github.zhuo.algorithm.leetcode.problems.problems3201_3300;

/**
 * 统计 X 和 Y 频数相等的子矩阵数量
 *
 * 给你一个二维字符矩阵 grid，其中 grid[i][j] 可能是 'X'、'Y' 或 '.'，返回满足以下条件的子矩阵数量：
 *
 * 包含 grid[0][0]
 * 'X' 和 'Y' 的频数相等。
 * 至少包含一个 'X'。
 */
public class Solution3212 {

    /**
     * beats 100%
     */
    public int numberOfSubmatrices(char[][] grid) {
        int ans = 0;
        int[][] colCnt = new int[grid[0].length][2];
        for (char[] row : grid) {
            int s0 = 0;
            int s1 = 0;
            for (int j = 0; j < row.length; j++) {
                if (row[j] != '.') {
                    colCnt[j][row[j] & 1]++;
                }
                s0 += colCnt[j][0];
                s1 += colCnt[j][1];
                if (s0 > 0 && s0 == s1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}