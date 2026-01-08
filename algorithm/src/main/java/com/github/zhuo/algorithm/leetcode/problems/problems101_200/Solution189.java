package com.github.zhuo.algorithm.leetcode.problems.problems101_200;

/**
 * 轮转数组
 * https://leetcode.cn/problems/rotate-array/?plan=algorithms&plan_progress=zh6v04j
 *
 * 难度 中等
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -2^31 <= nums[i] <= 2^31 - 1
 * 0 <= k <= 10^5
 *
 * 进阶：
 *  尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 *  你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 */
public class Solution189 {

    public static void main(String[] args) {

    }

    /**
     * 解法1: 使用新的数组来存放原值
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] numNew = new int[length];
        for (int i = 0; i < length; i++) {
            numNew[(i+k)%length] = nums[i];
        }
        System.arraycopy(numNew, 0, nums, 0, length);
    }
}
