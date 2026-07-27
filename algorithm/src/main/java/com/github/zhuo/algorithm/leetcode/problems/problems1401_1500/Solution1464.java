package com.github.zhuo.algorithm.leetcode.problems.problems1401_1500;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/
 *
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 *
 * 请你计算并返回该式的最大值。
 *
 */
public class Solution1464 {

    public static void main(String[] args) {

    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 59.15% 的用户
     * 内存消耗： 41 MB , 在所有 Java 提交中击败了 44.57% 的用户
     * 通过测试用例： 104 / 104
     */
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int index = nums.length;
        return (nums[index-2]-1)*(nums[index-1]-1);
    }

    /**
     * beats 77.19%
     */
    public int maxProduct1(int[] nums) {
        int first=0;
        int second=0;
        for(int i=0;i<nums.length;i++){
            second=Math.max(second,nums[i]);
            if(second>first){
                int temp=second;
                second=first;
                first=temp;
            }
        }
        return (first-1)*(second-1);
    }

    /**
     * beats 100%
     */
    public int maxProduct2(int[] nums) {
        int max1=0;
        int max2=0;
        for(int num:nums){
            if(num>max1){
                max2=max1;
                max1=num;
            }
            else if(num>max2){
                max2=num;
            }
        }
        return (max1 - 1)*(max2 -1);

    }
}
