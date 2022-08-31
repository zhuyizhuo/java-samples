package com.github.zhuo.algorithm.leetcode.problems.problems901_1000.problems977;

/**
 * https://leetcode.cn/problems/squares-of-a-sorted-array/
 * 有序数组的平方
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 */
public class SortedSquares {

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};
//        int[] nums = new int[]{-7,-3,2,3,11};
        int[] ints = sortedSquares(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    /**
     * 双指针 依次放入
     * 由于该题强调了非递减  理解为 递增或者有相等的值 如果是递增数组 该题可以去掉最后一个 else
     */
    public static int[] sortedSquares(int[] nums) {
        int[] rtn = new int[nums.length];
        int start = 0;
        int n = nums.length - 1;
        int end = nums.length - 1;
        while (start <= end){
            int leftPow = (int)Math.pow(nums[start], 2f);
            int rightPow = (int)Math.pow(nums[end], 2f);
            if (leftPow > rightPow){
                rtn[n] = leftPow;
                n--;
                start++;
            } else if (leftPow < rightPow){
                rtn[n] = rightPow;
                n--;
                end--;
            } else {
                rtn[n] = leftPow;
                n--;
                if (start == end){
                    break;
                }
                start++;
                rtn[n] = rightPow;
                n--;
                end--;
            }
        }
        return rtn;
    }
}
