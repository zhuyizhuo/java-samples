package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900;

/**
 * https://leetcode-cn.com/problems/minimum-absolute-sum-difference/
 * 难度 中等
 *
 * 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 *
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 *
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 *
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 10^9 + 7 取余 后返回。
 *
 * |x| 定义为：
 *
 * 如果 x >= 0 ，值为 x ，或者
 * 如果 x <= 0 ，值为 -x
 *
 */
public class Solution1818 {

    public static void main(String[] args) {
        System.out.println(minAbsoluteSumDiff(new int[]{1,7,5}, new int[]{2,3,5}));
        System.out.println(minAbsoluteSumDiff(new int[]{2,4,6,8,10}, new int[]{2,4,6,8,10}));
        System.out.println(minAbsoluteSumDiff(new int[]{1,10,4,4,2,7}, new int[]{9,3,5,1,7,4}));
    }

    /**
     * 思路
     *  找到相差最大的两数的下标
     *  然后分别在两个数组内找该下标与其他下标的最小差值
     */
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
//        int length = nums1.length;
//        int max = Integer.MIN_VALUE;
//        int index = 0;
//        long sum = 0;
//        for (int i = 0; i < length; i++) {
//            int s = Math.abs(nums1[i] - nums2[i]);
//            if (s >= max){
//                index = i;
//                max = s;
//            }
//            sum += s;
//        }
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < length; i++) {
//            int curr = Math.abs(nums1[i] - nums2[index]);
//            min = Math.min(min, curr);
//        }
//        return (int)((sum - max + min)%1000000007);
        return 0;
    }
}
