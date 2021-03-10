package com.github.zhuo.algorithm.leetcode.problems1_100.problems11;

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * 最大区域问题
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,4}));
    }

    /**
     * 题目思路
     *  分析题目，可知  盛水的区域容量 = 较小的边的长度 * 两边的间距
     *  利用双指针，算得区域大小后，将较短的边向中间移动，可最大化区域面积，
     *  最终可实现O(n)级别的时间复杂度算出最大区域面积，即只迭代一次数组
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left != right){
            if (height[left] >= height[right]){
                maxArea = Math.max(maxArea, height[right] * (right - left));
                //如果左边较长 则将右边向中间移动
                right--;
            } else {
                maxArea = Math.max(maxArea, height[left] * (right - left));
                //如果右边较长 则将左边向中间移动
                left++;
            }
        }
        return maxArea;
    }

}
