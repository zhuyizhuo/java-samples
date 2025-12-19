package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900;

public class Solution1863 {

    public static void main(String[] args) {
        SumOfAllSubsetXORTotals test5759 = new Solution1863();
        System.out.println(test5759.subsetXORSum(new int[]{1, 3}));
        System.out.println(test5759.subsetXORSum(new int[]{5, 1, 6}));
        System.out.println(test5759.subsetXORSum(new int[]{3, 4, 5, 6, 7, 8}));
    }

    int total = 0;

    public int subsetXORSum(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i-1] ^ nums[i];
            total += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, i, nums[i]);
        }
        return total;
    }

    private void dfs(int[] nums, int i, int num) {
        if (i == nums.length){
            return;
        }
        for (int j = i + 1; j < nums.length; j++) {
            total += num ^ nums[j];
            dfs(nums, j, num ^ nums[j]);
        }
    }
}
