package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems88;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * 合并两个有序数组
 *
 * 难度: 简单
 * 
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        //todo 待优化
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        merge(nums1, 3, new int[]{2,5,6}, 3);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

    /**
     * 简单粗暴的解法
     * 此解法并没用到原数组有序这一条件
     * 执行用时: 1 ms
     * 内存消耗: 38.6 MB
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0){
            return;
        }
        int len = nums1.length;
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (nums1[i] == 0){
                nums1[i] = nums2[index];
                index++;
            }
            if (index >= n){
                break;
            }
        }
        Arrays.sort(nums1);
    }
}
