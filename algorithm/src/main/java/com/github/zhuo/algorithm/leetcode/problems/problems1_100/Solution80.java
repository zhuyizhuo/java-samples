package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * 删除有序数组中的重复项 II
 * 难度 中等
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums 已按升序排列
 */
public class Solution80 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,1,1,1,1}));
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,2,2,3}));
        System.out.println(removeDuplicates(new int[]{1,1,1,1,1,2,2,2,2,3,3,3,4,4}));
        System.out.println(removeDuplicates(new int[]{1,2,3,4,5,6}));
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 67.15% 的用户
     * 内存消耗： 38.8 MB , 在所有 Java 提交中击败了 12.07% 的用户
     */
    public static int removeDuplicates(int[] nums) {
        int newLen = 1;
        //可赋值元素的下标
        int index = 1;
        //当前元素重复次数
        int count = 1;
        //上一个元素
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //元素等于上一个元素 则重复元素数量加一
            if (nums[i] == last){
                count++;
            } else {
                count = 1;
            }
            //小于两个重复元素 则给当前下标元素赋值 数组长度加一 下标右移
            if (count <= 2){
                nums[index] = nums[i];
                last = nums[i];
                newLen ++;
                index ++;
            }
        }
        return newLen;
    }

}
