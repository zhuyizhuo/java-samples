package com.github.zhuo.algorithm.leetcode.problems.problems1401_1500;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 *
 * 绝对差不超过限制的最长连续子数组
 *
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 *
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 */
public class Solution1438 {

    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{8,2,4,7}, 4));
    }

    /**
     * 分析题意，子数组中的任意两个元素之间的绝对差必须小于或者等于 limit。
     * 可转换为  只要子数组中最大与最小元素的绝对差小于或者等于 limit 即可
     *
     * 执行用时： 43 ms , 在所有 Java 提交中击败了 55.11% 的用户
     * 内存消耗： 55 MB , 在所有 Java 提交中击败了 65.18% 的用户
     */
    public static int longestSubarray(int[] nums, int limit) {
        int left = 0,right = 0;
        int length = nums.length;
        //单调递减队列 队首最大
        Deque<Integer> queMax = new LinkedList();
        //单调递增队列 队首最小
        Deque<Integer> queMin = new LinkedList();
        int resp = 0;
        while (right < length){
            //如果单调递减队列的最后一位小于当前元素  则移除最后一位
            while (!queMax.isEmpty() && queMax.peekLast() < nums[right]){
                queMax.pollLast();
            }
            //如果单调递增队列的最后一位大于当前元素  则移除最后一位
            while (!queMin.isEmpty() && queMin.peekLast() > nums[right]){
                queMin.pollLast();
            }
            //将当前元素添加到队尾
            queMax.offerLast(nums[right]);
            queMin.offerLast(nums[right]);
            while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit){
                if (nums[left] == queMin.peekFirst()){
                    queMin.pollFirst();
                }
                if (nums[left] == queMax.peekFirst()){
                    queMax.pollFirst();
                }
                left++;
            }
            resp = Math.max(resp, right - left + 1);
            right++;
        }
        return resp;
    }

}
