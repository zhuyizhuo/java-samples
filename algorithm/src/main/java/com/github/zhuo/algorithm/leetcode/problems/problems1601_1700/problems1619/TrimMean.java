package com.github.zhuo.algorithm.leetcode.problems.problems1601_1700.problems1619;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/
 * 删除某些元素后的数组均值
 * 难度 简单
 * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，剩余数字的平均值。
 *
 * 与 标准答案 误差在 10^-5 的结果都被视为正确结果。
 */
public class TrimMean {

    public static void main(String[] args) {
        double v = trimMean(new int[]{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3});
        System.out.println(v);
    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 99.73% 的用户
     * 内存消耗： 40.9 MB , 在所有 Java 提交中击败了 95.10% 的用户
     * 通过测试用例： 50 / 50
     */
    public static double trimMean(int[] arr) {
        Arrays.sort(arr);
        int length = arr.length;
        int tmp = length / 20;
        int total = 0;
        for (int i = tmp; i < arr.length - tmp; i++) {
            total += arr[i];
        }
        int count = arr.length - tmp * 2;
        return total * 1.0 / count;
    }
}
