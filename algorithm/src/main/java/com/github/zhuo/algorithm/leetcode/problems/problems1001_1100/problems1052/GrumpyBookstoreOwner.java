package com.github.zhuo.algorithm.leetcode.problems.problems1001_1100.problems1052;

/**
 * https://leetcode-cn.com/problems/grumpy-bookstore-owner/
 *
 * 爱生气的书店老板
 *
 * 难度 中等
 *
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，所有这些顾客都会在那一分钟结束后离开。
 *
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 *
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 *
 * 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。
 *
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 * 输出：16
 * 解释：
 * 书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 *
 * 提示：
 *  1 <= X <= customers.length == grumpy.length <= 20000
 *  0 <= customers[i] <= 1000
 *  0 <= grumpy[i] <= 1
 *
 */
public class GrumpyBookstoreOwner {

    public static void main(String[] args) {
        System.out.println(maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
    }

    /**
     * 分析题意
     *  先获取老板所有生气的分钟数及对应分钟进入书店的客户数量，
     *  并计算出老板没生气的其他时间的客户数量总和
     *
     *  找到 结束分钟-开始分钟 <=X 且客户数量总和最大的区间,
     *  用没生气的其他时间数量总和加上当前的最大数量 即为所求。
     *
     *  执行用时： 3 ms , 在所有 Java 提交中击败了 79.44% 的用户
     *  内存消耗： 40.9 MB , 在所有 Java 提交中击败了 58.16% 的用户
     */
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        /** 没生气的时间客户数量 */
        int max = 0;
        int angryMax = 0;
        /** 在 X 分钟不生气区间内的可挽回最大客户数量 */
        int currMax = 0;
        int start = 0;
        int end = 0;
        int length = grumpy.length;
        while (end < length){
            //统计没生气时间的客户数量
            if (grumpy[end] == 0){
                max += customers[end];
            } else {
                //如果生气了并且下标之差小于 X
                if (end - start + 1<= X){
                    currMax += customers[end];
                    angryMax = Math.max(angryMax, currMax);
                }
            }
            end++;
            //如果区间超过了最大区间 则将开始下标右移
            while (end - start + 1 > X) {
                //右移过程中遇到了生气的分钟，则减去当前分钟的客户
                if (grumpy[start] == 1){
                    currMax -= customers[start];
                }
                start ++;
            }
        }
        return max + angryMax;
    }
}
