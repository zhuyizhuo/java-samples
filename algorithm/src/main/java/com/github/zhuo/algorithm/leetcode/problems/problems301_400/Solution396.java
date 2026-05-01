package com.github.zhuo.algorithm.leetcode.problems.problems301_400;

public class Solution396 {

    /**
     * beats 100%
     */
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        int f=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        for(int i=0;i<n;i++){
            f+=i*nums[i];
        }
        int max=f;
        for(int i=n-1;i>0;i--){
            f+=sum-n*nums[i];
            max=Math.max(max,f);
        }
        return max;
    }
}