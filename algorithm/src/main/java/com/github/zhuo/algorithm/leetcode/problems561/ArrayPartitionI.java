package com.github.zhuo.algorithm.leetcode.problems561;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/array-partition-i/
 * 数组拆分 I
 */
public class ArrayPartitionI {

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{6,2,6,5,1,2}));
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0){
                sum+=nums[i];
            }
        }
        return sum;
    }
}
