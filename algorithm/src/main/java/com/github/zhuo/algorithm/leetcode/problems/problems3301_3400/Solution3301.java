package com.github.zhuo.algorithm.leetcode.problems.problems3301_3400;

import java.util.Arrays;

/**
 * 给你一个数组 maximumHeight ，其中 maximumHeight[i] 表示第 i 座塔可以达到的 最大 高度。
 *
 * 你的任务是给每一座塔分别设置一个高度，使得：
 *
 * 第 i 座塔的高度是一个正整数，且不超过 maximumHeight[i] 。
 * 所有塔的高度互不相同。
 * 请你返回设置完所有塔的高度后，可以达到的 最大 总高度。如果没有合法的设置，返回 -1 。
 *
 *
 * 示例 1：
 *
 * 输入：maximumHeight = [2,3,4,3]
 *
 * 输出：10
 *
 * 解释：
 *
 * 我们可以将塔的高度设置为：[1, 2, 4, 3] 。
 *
 * 示例 2：
 *
 * 输入：maximumHeight = [15,10]
 *
 * 输出：25
 *
 * 解释：
 *
 * 我们可以将塔的高度设置为：[15, 10] 。
 *
 * 示例 3：
 *
 * 输入：maximumHeight = [2,2,1]
 *
 * 输出：-1
 *
 * 解释：
 *
 * 无法设置塔的高度为正整数且高度互不相同。
 *
 *
 * 提示：
 *
 * 1 <= maximumHeight.length <= 10^5
 * 1 <= maximumHeight[i] <= 10^9
 */
public class Solution3301 {

    /**
     * beats 58.82%
     */
    public long maximumTotalSum(int[] maximumHeight) {
        long sum = 0;
        Arrays.sort(maximumHeight);
        int n = maximumHeight.length;
        int MX = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            MX = Math.min(MX - 1, maximumHeight[i]);
            sum += MX;
            if (MX <= 0) {
                return -1;
            }
        }
        return sum;
    }
}
