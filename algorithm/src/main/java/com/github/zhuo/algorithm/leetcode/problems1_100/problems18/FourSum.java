package com.github.zhuo.algorithm.leetcode.problems1_100.problems18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/4sum/
 *
 * 四数之和
 * 难度 中等
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 * 答案中不可以包含重复的四元组。
 *
 * 0 <= nums.length <= 200
 * - 10^9 <= nums[i] <=  10^9
 * - 10^9 <= target <=  10^9
 */
public class FourSum {

    public static void main(String[] args) {
        //TODO 待三数之和的时间复杂度优化后再解答该题
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resp = new ArrayList<>();
        if (nums.length < 4){
            return resp;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length; i++) {

        }
        return null;
    }
}
