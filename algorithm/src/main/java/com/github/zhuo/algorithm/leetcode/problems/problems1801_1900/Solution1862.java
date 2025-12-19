package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode-cn.com/problems/sum-of-floored-pairs/
 * 向下取整数对和
 * 难度 困难
 *
 *  给你一个整数数组 nums ，请你返回所有下标对 0 <= i, j < nums.length 的 floor(nums[i] / nums[j]) 结果之和。
 *  由于答案可能会很大，请你返回答案对10^9 + 7 取余 的结果。
 *
 * 函数 floor() 返回输入数字的整数部分。
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 */
public class Solution1862 {

    public static void main(String[] args) {
        //TODO
//        System.out.println(sumOfFlooredPairs(new int[]{2,5,9}));
        System.out.println(sumOfFlooredPairs(new int[]{7,7,7,7,7,7,7}));
    }

    static AtomicInteger total = new AtomicInteger();

    public static int sumOfFlooredPairs(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int finalI = i;
            new Thread(() -> dfs(nums, 0, nums[finalI])).run();
        }

        return total.get() % 1000_000_007;
    }

    private static void dfs(int[] nums, int i, int num) {
        int i1 = num / nums[i];
        if (i1 == 0){
            return;
        }
        total.getAndAdd(i1);
        if (i == nums.length - 1){
            return;
        }
        dfs(nums, i+1, num);
    }

}
