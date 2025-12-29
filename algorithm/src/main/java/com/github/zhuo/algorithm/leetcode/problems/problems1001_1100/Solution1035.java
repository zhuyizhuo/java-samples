package com.github.zhuo.algorithm.leetcode.problems.problems1001_1100;

/**
 * https://leetcode-cn.com/problems/uncrossed-lines/
 * 不相交的线
 * 难度 中等
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 *
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 *
 *  nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 *
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 *
 * 提示：
 *
 * 1 <= nums1.length <= 500
 * 1 <= nums2.length <= 500
 * 1 <= nums1[i], nums2[i] <= 2000
 */
public class Solution1035 {

    /**
     * 3ms
     * beats 100%  sometime 99.93%
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[] dp=new int[nums2.length+1];
        for(int i=1;i<=nums1.length;i++){
            for(int j=nums2.length;j>0;j--){
                if(nums1[i-1]==nums2[j-1])dp[j]=dp[j-1]+1;
            }
            for(int j=1;j<=nums2.length;j++)dp[j]=dp[j]>dp[j-1]?dp[j]:dp[j-1];
        }
        return dp[nums2.length];
    }
}
