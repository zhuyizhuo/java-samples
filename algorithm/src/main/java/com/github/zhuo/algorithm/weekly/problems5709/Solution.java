package com.github.zhuo.algorithm.weekly.problems5709;

public class Solution {

    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10,20,30,5,10,50}));
        System.out.println(maxAscendingSum(new int[]{10,20,30,40,50}));
        System.out.println(maxAscendingSum(new int[]{12,17,15,13,10,11,12}));
        System.out.println(maxAscendingSum(new int[]{100,10,1}));
        System.out.println(maxAscendingSum(new int[]{100}));
    }


    public static int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int curr = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]){
                curr += nums[i];
                max = Math.max(curr, max);
            } else {
                curr = nums[i];
            }
        }
        return max;
    }

}
