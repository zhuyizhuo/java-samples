package com.github.zhuo.algorithm.leetcode.problems.problems701_800;

/**
 * https://leetcode-cn.com/problems/find-pivot-index/
 *
 * 寻找数组的中心索引
 */
public class Solution724 {

    public static void main(String[] args) {
        //todo 优化更优解
    }

    /**
     * 暴力解法
     * 直接计算左右的和比对
     */
    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int leftSum = 0;
            for (int j = i - 1; j >= 0; j--) {
                leftSum += nums[j];
            }
            int rightSum = 0;
            for (int j = i + 1; j < nums.length; j++) {
                rightSum += nums[j];
            }
            if (leftSum == rightSum){
                return i;
            }
        }
        return -1;
    }

}
