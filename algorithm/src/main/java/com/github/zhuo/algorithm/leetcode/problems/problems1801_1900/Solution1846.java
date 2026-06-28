package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900;

/**
 * 减小和重新排列数组后的最大元素
 */
public class Solution1846 {

    /**
     * beats 99.58%
     */
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n=arr.length;
        int[] cnt=new int[n+1];
        for(int x:arr){
            cnt[Math.min(x,n)]++;
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            ans=Math.min(i,ans+cnt[i]);
        }
        return ans;
    }
}