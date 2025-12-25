package com.github.zhuo.algorithm.leetcode.problems.problems701_800;

/**
 * https://leetcode-cn.com/problems/binary-search/
 *
 * 二分查找
 *
 * 难度 简单
 *
 * 提示
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 */
public class Solution704 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(search1(nums, 6));
        System.out.println(search1(nums, 1));
        System.out.println(search1(nums, 5));
        System.out.println(search1(nums, 2));
    }

    /**
     * 暴力解法 与题意不符
     */
    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 42.2 MB , 在所有 Java 提交中击败了 36.96% 的用户
     * 通过测试用例： 47 / 47
     */
    public static int search1(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int middle = start + (end - start)/2;
            if (nums[middle] == target){
                return middle;
            }
            if (nums[middle] < target){
                start = middle + 1;
            } else if (nums[middle] > target){
                end = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 如果 nums.length 为 integer 最大值 则此解法会类型溢出
     */
    public static int search11(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        while (start < end){
            int index = (start + end)/2;
            if (nums[index] == target){
                return index;
            } if (nums[index] > target){
                start = index;
            } else {
                end = index;
            }
        }
        return -1;
    }
}
