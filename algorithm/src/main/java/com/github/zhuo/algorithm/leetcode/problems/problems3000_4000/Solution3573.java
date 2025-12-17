package com.github.zhuo.algorithm.leetcode.problems.problems3000_4000;

/**
 * 给你一个整数数组 prices，其中 prices[i] 是第 i 天股票的价格（美元），以及一个整数 k。
 *
 * 你最多可以进行 k 笔交易，每笔交易可以是以下任一类型：
 *
 * 普通交易：在第 i 天买入，然后在之后的第 j 天卖出，其中 i < j。你的利润是 prices[j] - prices[i]。
 *
 * 做空交易：在第 i 天卖出，然后在之后的第 j 天买回，其中 i < j。你的利润是 prices[i] - prices[j]。
 *
 * 注意：你必须在开始下一笔交易之前完成当前交易。此外，你不能在已经进行买入或卖出操作的同一天再次进行买入或卖出操作。
 *
 * 通过进行 最多 k 笔交易，返回你可以获得的最大总利润。
 *
 * 示例：
 * 输入: prices = [1,7,9,8,2], k = 2
 *
 * 输出: 14
 *
 * 解释:
 *
 * 我们可以通过 2 笔交易获得 14 美元的利润：
 * 一笔普通交易：第 0 天以 1 美元买入，第 2 天以 9 美元卖出。
 * 一笔做空交易：第 3 天以 8 美元卖出，第 4 天以 2 美元买回。
 *
 * 2 <= prices.length <= 10^3
 * 1 <= prices[i] <= 10^9
 * 1 <= k <= prices.length / 2
 */
public class Solution3573 {

    public static void main(String[] args) {

    }

    public long maximumProfit(int[] prices, int k) {

        return 0;
    }

}
