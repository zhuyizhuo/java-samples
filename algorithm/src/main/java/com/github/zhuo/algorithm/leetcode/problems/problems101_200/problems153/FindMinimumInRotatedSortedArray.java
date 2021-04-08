package com.github.zhuo.algorithm.leetcode.problems.problems101_200.problems153;

public class FindMinimumInRotatedSortedArray {

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
