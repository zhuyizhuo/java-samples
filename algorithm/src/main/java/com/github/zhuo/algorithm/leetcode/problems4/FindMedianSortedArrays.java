package com.github.zhuo.algorithm.leetcode.problems4;

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
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedian(new int[]{}));
        //TODO
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Len = nums1.length;
        int num2Len = nums2.length;
        if (num1Len == 0) {
            return findMedian(nums2);
        }
        if (num2Len == 0) {
            return findMedian(nums1);
        }
        Integer median = findMedian(nums1);
        Integer median1 = findMedian(nums2);
        if (median == median1) {
            return median;
        }
        int left = (num1Len + num2Len + 1) / 2;
        int right = (num1Len + num2Len + 2) / 2;

        return 0;
    }

    private static Integer findMedian(int[] nums) {
        int len = nums.length;
        if (len % 2 == 0) {
            int i = len / 2;
            return (nums[i] + nums[i - 1]) / 2;
        } else {
            return nums[len / 2];
        }
    }

}
