package com.github.zhuo.algorithm.leetcode.problems.problems901_1000;

/**
 * https://leetcode-cn.com/problems/longest-turbulent-subarray/
 *
 * 最长湍流子数组
 *
 * 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 *
 * 若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 * 或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 *
 * 返回 A 的最大湍流子数组的长度。
 *
 */
public class Solution978 {

    public static void main(String[] args) {
        //5
        System.out.println(maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
        //2
        System.out.println(maxTurbulenceSize(new int[]{4,8,12,16}));
        //3
        System.out.println(maxTurbulenceSize(new int[]{3,3,4,3,3}));
    }

    public static int maxTurbulenceSize(int[] arr) {
        int max = 1;
        int curr = 1;

        int lastCompare = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (i < len - 1){
                if (arr[i] == arr[i+1]){
                    curr = 1;
                    lastCompare = 0;
                    continue;
                }
                int currCompare = arr[i] > arr[i+1] ? 1 : -1;
                //如果当前比对结果和上一个比对结果相反，则长度+1
                if (currCompare == -lastCompare){
                    curr++;
                    max = Math.max(curr, max);
                } else {
                    //如果当前比对结果和上一个比对结果相同 则将长度置为2 因为大于或者小于至少两个数字
                    curr=2;
                }
                lastCompare = currCompare;
            }
        }
        return Math.max(curr, max);
    }
}
