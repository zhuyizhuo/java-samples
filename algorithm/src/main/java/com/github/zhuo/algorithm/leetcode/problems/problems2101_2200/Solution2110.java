package com.github.zhuo.algorithm.leetcode.problems.problems2101_2200;

/**
 * 给你一个整数数组 prices ，表示一支股票的历史每日股价，其中 prices[i] 是这支股票第 i 天的价格。
 *
 * 一个 平滑下降的阶段 定义为：对于 连续一天或者多天 ，每日股价都比 前一日股价恰好少 1 ，这个阶段第一天的股价没有限制。
 *
 * 请你返回 平滑下降阶段 的数目。
 *
 * 输入：prices = [3,2,1,4]
 * 输出：7
 * 解释：总共有 7 个平滑下降阶段：
 * [3], [2], [1], [4], [3,2], [2,1] 和 [3,2,1]
 * 注意，仅一天按照定义也是平滑下降阶段。
 */
public class Solution2110 {

    public static void main(String[] args) {
        int[] p = new int[]{3,2,1,4};
        System.out.println(getDescentPeriods(p));
    }

    public static long getDescentPeriods(int[] prices) {
        long count = 1;
        long current = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i-1] == prices[i] + 1){
                current += 1;
            } else {
                current = 1;
            }
            count += current;
        }
        return count;
    }

}
