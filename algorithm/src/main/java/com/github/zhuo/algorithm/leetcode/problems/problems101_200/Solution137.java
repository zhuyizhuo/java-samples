package com.github.zhuo.algorithm.leetcode.problems.problems101_200;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/single-number-ii/
 * 只出现一次的数字 II
 * 难度 中等
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 *
 */
public class Solution137 {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,3,2}));
        System.out.println(singleNumber(new int[]{0,1,0,1,0,1,99}));
        System.out.println(singleNumber(new int[]{0,1,0,99,0,99,99}));
    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 67.50% 的用户
     * 内存消耗： 38.3 MB , 在所有 Java 提交中击败了 35.59% 的用户
     */
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 == nums.length){
                return nums[i];
            }
            if (nums[i] == nums[i+1]){
                i += 2;
                continue;
            } else {
                return nums[i];
            }
        }
        return -1;
    }

}
