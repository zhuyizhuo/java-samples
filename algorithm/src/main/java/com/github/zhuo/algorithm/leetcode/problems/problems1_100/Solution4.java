package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

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
public class Solution4 {

    public static void main(String[] args) {
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

/**
 * beats 100%
 */
class FindMedianSortedArrays1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = (length1+length2);
        if(totalLength%2==1){
            return findElement(nums1, nums2, totalLength/2+1);
        }else{
            return (findElement(nums1, nums2 ,totalLength/2+1)+findElement(nums1, nums2 ,totalLength/2))/2.0;
        }
    }

    public int findElement(int[] nums1, int[] nums2, int k){
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = k/2;
        while(true){
            if(index1==length1){
                return nums2[index2+k-1];
            }
            if(index2==length2){
                return nums1[index1+k-1];
            }
            if(k==1){
                return Math.min(nums1[index1],nums2[index2]);
            }
            int half = k/2;
            int newIndex1 = Math.min(index1+half,length1)-1;
            int newIndex2 = Math.min(index2+half,length2)-1;
            int prviot1 = nums1[newIndex1],prviot2 = nums2[newIndex2];
            if(prviot1<=prviot2){
                k-=(newIndex1-index1+1);
                index1 = newIndex1+1;
            }else{
                k-=(newIndex2-index2+1);
                index2 = newIndex2+1;
            }
        }
    }
}
