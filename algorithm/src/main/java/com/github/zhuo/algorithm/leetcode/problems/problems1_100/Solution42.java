package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * 接雨水
 * 难度 困难
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 *
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 提示：
 *
 * n == height.length
 * 0 <= n <= 3 * 10^4
 * 0 <= height[i] <= 10^5
 */
public class Solution42 {

    public static void main(String[] args) {
        System.out.println();
    }

    /**
     * beats 100%
     */
    public int trap(int[] height) {
        int leftA = height[0] , rightB = height[height.length-1];
        int left = 0 , right = height.length-1;
        int sum = 0;
        while( left <= right ){
            if( height[left] < height[right] ){
                leftA = Math.max(leftA,height[left]);
                sum += leftA - height[left];
                left++;
            } else {
                rightB = Math.max(rightB,height[right]);
                sum += rightB - height[right];
                right--;
            }
        }
        return sum;
    }
}
