package com.github.zhuo.algorithm.weekly;

public class MaximumSubarrayMinProduct {

    public static void main(String[] args) {
//        System.out.println(maxSumMinProduct(new int[]{1,2,3,2}));
//        System.out.println(maxSumMinProduct(new int[]{2,3,3,1,2}));
//        System.out.println(maxSumMinProduct(new int[]{3,1,5,6,4,2}));
        //25
        System.out.println(maxSumMinProduct(new int[]{1,1,3,2,2,2,1,5,1,5}));
    }

    //子数组最小乘积的最大值
    public static int maxSumMinProduct(int[] nums) {
        int[][] minVal = new int[nums.length][nums.length];
        int[][] sum = new int[nums.length][nums.length];
        long max = 0;
        for (int i = 0; i < nums.length; i++) {
            minVal[i][i] = nums[i];
            sum[i][i] = nums[i];
            max = Math.max(max, minVal[i][i] * sum[i][i]);
        }
        for (int i = 2; i <= nums.length; i++) {
            for (int left = 0; left + i - 1 < nums.length; left++) {
                int right = left + i - 1;
                minVal[left][right] = Math.min(minVal[left][right-1], nums[right]);
                sum[left][right] = sum[left][right-1] + nums[right];
                if ((minVal[left][right] * sum[left][right]) > max){
                    max = minVal[left][right] * sum[left][right];
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                System.out.println(minVal[i][j] + " " + sum[i][j]);
            }
        }
        return (int)(max%1000_000_007);
    }
}
