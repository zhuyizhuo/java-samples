package com.github.zhuo.algorithm.leetcode.problems.problems3601_3700;

/**
 * 区间乘法查询后的异或 I
 *
 * 给你一个长度为 n 的整数数组 nums 和一个大小为 q 的二维整数数组 queries，其中 queries[i] = [li, ri, ki, vi]。
 *
 * 对于每个查询，按以下步骤执行操作：
 *
 * 设定 idx = li。
 * 当 idx <= ri 时：
 * 更新：nums[idx] = (nums[idx] * vi) % (10^9 + 7)
 * 将 idx += ki。
 * 在处理完所有查询后，返回数组 nums 中所有元素的 按位异或 结果。
 */
public class Solution3653 {

    long MOD =(long)10e8+7;

    /**
     * beats 98.67%
     */
    public int xorAfterQueries(int[] nums, int[][] q) {
        int n= nums.length;
        long arr[] =new long[n];
        for(int i=0;i<n;i++){
            arr[i] = (long)nums[i];
        }
        for(int i=0;i<q.length;i++){
            for(int j=q[i][0];j<=q[i][1];j+=q[i][2]){
                arr[j]=(arr[j]*(long)q[i][3])%MOD;
            }
        }
        long ans =0;
        for(int i=0;i<n;i++){
            ans = ans^arr[i];
        }
        return (int)ans;
    }
}