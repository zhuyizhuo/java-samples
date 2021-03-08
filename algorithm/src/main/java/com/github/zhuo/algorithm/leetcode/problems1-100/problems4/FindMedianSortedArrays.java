package com.github.zhuo.algorithm.leetcode.problems4;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * Follow up: The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 *
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 *
 * Example 3:
 *
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 *
 * Example 4:
 *
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 *
 * Example 5:
 *
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 *
 * 中位数定义:
 * 中位数（Median）又称中值，统计学中的专有名词，是按顺序排列的一组数据中居于中间位置的数，
 * 代表一个样本、种群或概率分布中的一个数值，其可将数值集合划分为相等的上下两部分。
 * 对于有限的数集，可以通过把所有观察值高低排序后找出正中间的一个作为中位数。
 * 如果观察值有偶数个，通常取最中间的两个数值的平均数作为中位数。
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        //TODO 本题难点为 优化时间复杂度到 O(log (m+n))
        System.out.println(findMedianSortedArrays(new int[]{1, 2, 3, 4, 5}, new int[]{8}));
    }

    /**
     * 先用最基础的解法解出来该题:
     *  合并排序取中
     *  复杂度为 O(m+n) + O(m+n log(m+n))
     *
     *  执行用时： 3 ms , 在所有 Java 提交中击败了 82.69% 的用户
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength == 0){
            return 0;
        }
        int[] all = new int[totalLength];
        System.arraycopy(nums1, 0, all, 0, nums1.length);
        System.arraycopy(nums2, 0, all, nums1.length, nums2.length);
        Arrays.sort(all);
        //奇数
        if (totalLength % 2 != 0) {
            //因为数组下标从 0 开始, 所以减去 1
            int middleIndex = (totalLength + 1 )/ 2 - 1;
            return all[middleIndex];
        }
        //偶数
        int left = totalLength / 2 - 1;
        int right = totalLength / 2;
        return (double) (all[left] + all[right]) / 2;
    }

}
