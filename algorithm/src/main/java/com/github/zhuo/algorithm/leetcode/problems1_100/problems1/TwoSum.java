package com.github.zhuo.algorithm.leetcode.problems1_100.problems1;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 你可以按任意顺序返回答案。
 *
 * 难度 简单
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    /**
     *
     * 思路 使用哈希表，循环给定数组，从哈希表中获取目标数字与当前数字的差，
     * 未获取到则将当前数字及下标放入哈希表
     * 获取到的话 返回当前数字下标及哈希表中数字下标。
     *
     * 典型的 空间换时间，将时间复杂度降低至 O(n)
     *
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100% 的用户
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap();
        for (int i = 0,len=nums.length; i < len; i++) {
            Integer integer = m.get(target - nums[i]);
            if (integer != null){
                return new int[]{integer, i};
            } else {
                m.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }
}