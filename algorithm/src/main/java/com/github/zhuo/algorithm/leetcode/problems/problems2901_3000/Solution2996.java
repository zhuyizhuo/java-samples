package com.github.zhuo.algorithm.leetcode.problems.problems2901_3000;

/**
 * 大于等于顺序前缀和的最小缺失整数
 * easy
 */
public class Solution2996 {

    /**
     * beats 100%
     */
    public int missingInteger(int[] nums) {
        int[] newNum =new int[nums.length];
        int i = nums.length-1;
        newNum[0]=nums[0];
        for(int j=1;j<=i;j++){
            if(nums[j]==nums[j-1]+1){
                newNum[j]=nums[j];
            }else{
                break;
            }
        }
        int total=0;
        for(int a=0;a<newNum.length;a++){
            total=total+newNum[a];
        }
        for(int b=0;b<nums.length;b++){
            if(total==nums[b]){
                total++;
                b=-1;
            }
        }
        return total;
    }
}