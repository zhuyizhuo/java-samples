package com.github.zhuo.algorithm.leetcode.problems.problems3401_3500;

import java.util.Arrays;

/**
 * 机器人可以获得的最大金币数
 *
 * 给你一个 m x n 的网格。一个机器人从网格的左上角 (0, 0) 出发，目标是到达网格的右下角 (m - 1, n - 1)。在任意时刻，机器人只能向右或向下移动。
 *
 * 网格中的每个单元格包含一个值 coins[i][j]：
 *
 * 如果 coins[i][j] >= 0，机器人可以获得该单元格的金币。
 * 如果 coins[i][j] < 0，机器人会遇到一个强盗，强盗会抢走该单元格数值的 绝对值 的金币。
 * 机器人有一项特殊能力，可以在行程中 最多感化 2个单元格的强盗，从而防止这些单元格的金币被抢走。
 *
 * 注意：机器人的总金币数可以是负数。
 *
 * 返回机器人在路径上可以获得的 最大金币数 。
 */
public class Solution3418 {

    /**
     * beats 100%
     */
    public int maximumAmount(int[][] coins) {
        int n = coins[0].length;
        int[][] dp = new int[n + 1][3];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE / 2);
        }

        for (int i = 0; i < 3; i++) {
            dp[1][i] = 0;
        }
        for (int[] row : coins) {
            for (int j = 1; j <= n; j++) {
                int x = row[j - 1];
                dp[j][2] = Math.max(Math.max(dp[j - 1][2] + x, dp[j][2] + x),
                        Math.max(dp[j - 1][1], dp[j][1]));
                dp[j][1] = Math.max(Math.max(dp[j - 1][1] + x, dp[j][1] + x),
                        Math.max(dp[j - 1][0], dp[j][0]));
                dp[j][0] = Math.max(dp[j - 1][0], dp[j][0]) + x;
            }
        }

        return dp[n][2];
    }
}

