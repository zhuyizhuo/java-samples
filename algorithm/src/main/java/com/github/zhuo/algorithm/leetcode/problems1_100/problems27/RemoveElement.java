package com.github.zhuo.algorithm.leetcode.problems1_100.problems27;

/**
 *
 * https://leetcode-cn.com/problems/remove-element/
 * 移除元素
 * 难度 简单
 * 
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int i = removeElement(nums, 2);
        for (int j = 0; j < i; j++) {
            System.out.println(nums[j]);
        }
    }

    /**
     * 执行用时 0ms 超过 100% 的用户
     */
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }
        int index = nums.length;
        for (int i = 0; i < index; i++) {
            if (nums[i] == val) {
                for (int j = i; j < index - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                index--;
                i--;
            }
        }
        return index;
    }
}
