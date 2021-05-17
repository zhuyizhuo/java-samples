package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900.problems1855;

/**
 * https://leetcode-cn.com/problems/maximum-distance-between-a-pair-of-values/
 * 下标对中的最大距离
 * 难度 中等
 * 
 * 给你两个 非递增 的整数数组 nums1  和 nums2  ，数组下标均 从 0 开始 计数。
 *
 * 下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。
 * 如果该下标对同时满足 i <= j 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为 j - i   。
 *
 * 返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。
 *
 * 一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。
 *
 * 提示：
 *
 * 1 <= nums1.length <= 10^5
 * 1 <= nums2.length <= 10^5
 * 1 <= nums1[i], nums2[j] <= 10^5
 * nums1 和 nums2 都是 非递增 数组
 *
 */
public class MaximumDistanceBetweenAPairOfValues {

    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{55,30,5,4,2}, new int[]{100,20,10,10,5}));
        System.out.println(maxDistance(new int[]{2,2,2}, new int[]{10,10,1}));
        System.out.println(maxDistance(new int[]{30,29,19,5}, new int[]{25,25,25,25,25}));
        System.out.println(maxDistance(new int[]{5,4}, new int[]{3,2}));
    }

    //下标对中的最大距离
    public static int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + max; j < nums2.length; j++) {
                if (nums1[i] <= nums2[j]){
                    max = Math.max(max, j - i);
                } else {
                    break;
                }
            }
        }
        return max;
    }
}
