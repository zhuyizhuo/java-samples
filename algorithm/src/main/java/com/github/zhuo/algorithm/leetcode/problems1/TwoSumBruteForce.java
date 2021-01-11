package com.github.zhuo.algorithm.leetcode.problems1;

/**
 * 两数求和暴力解
 */
public class TwoSumBruteForce{

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ints = twoSum(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    /**
     * 暴力解法是拿每个数字和数组中另外所有数字求和与目标数字对比
     * 时间复杂度最差可达到 O(n^2)
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0, len = nums.length; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

}
