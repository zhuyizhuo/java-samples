package com.github.zhuo.algorithm.leetcode.problems.problems201_300.problems283;

/**
 * https://leetcode.cn/problems/move-zeroes/?plan=algorithms&plan_progress=zh6v04j
 * 移动零
 *
 * 难度 简单
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class MoveZeroes {

    public static void main(String[] args) {

    }

    /***
     * 0 1 0 2 0 0 0 3 0 4 0 5
     * [0,1,0,3,12]
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
