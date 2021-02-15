package com.github.zhuo.algorithm.leetcode.problems485;

/**
 * https://leetcode-cn.com/problems/max-consecutive-ones/
 *
 * 最大连续1的个数
 * 
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 *
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 *
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(nums[i] == 1){
                curr++;
                max = Math.max(curr,max);
            } else {
                curr = 0;
            }
        }
        return max;
    }
}
