package com.github.zhuo.algorithm.leetcode.problems.problems101_200;

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 寻找旋转排序数组中的最小值
 * 难度 中等
 *
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 */
public class Solution153 {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{11,13,15,17}));
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.6 MB , 在所有 Java 提交中击败了 93.40% 的用户
     */
    public static int findMin(int[] nums) {
        if (nums[0] < nums[nums.length-1]){
            return nums[0];
        }
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < min){
                return num;
            }
        }
        return min;
    }
}
