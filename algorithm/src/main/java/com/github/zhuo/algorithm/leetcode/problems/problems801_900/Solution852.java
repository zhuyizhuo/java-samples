package com.github.zhuo.algorithm.leetcode.problems.problems801_900;

/**
 * https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 * 山脉数组的峰顶索引
 * 难度 简单
 * 
 * 符合下列属性的数组 arr 称为 山脉数组 ：
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。
 *
 * 提示：
 *
 * 3 <= arr.length <= 104
 * 0 <= arr[i] <= 106
 * 题目数据保证 arr 是一个山脉数组
 */
public class Solution852 {

    public static void main(String[] args) {

    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 16.35% 的用户
     * 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 84.50% 的用户
     */
    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                return i;
            }
        }
        return -1;
    }

    public int peakIndexInMountainArray1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        return -1;
    }

}
