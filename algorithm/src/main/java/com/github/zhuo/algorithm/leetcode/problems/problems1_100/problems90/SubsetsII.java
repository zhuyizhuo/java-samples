package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets-ii/
 * 难度 中等
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 */
public class SubsetsII {

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,3,4,5}));
        System.out.println(subsetsWithDup(new int[]{2,2,2,2}));
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.5 MB , 在所有 Java 提交中击败了 88.57% 的用户
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resp = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        dfs(nums, resp, inner, 0);
        return resp;
    }

    private static void dfs(int[] nums, List<List<Integer>> resp, List<Integer> inner, int i) {
        resp.add(new ArrayList<>(inner));
        if (i == nums.length){
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j-1]){
                continue;
            }
            inner.add(nums[j]);
            dfs(nums, resp, inner, j + 1);
            inner.remove(inner.size() -  1);
        }
    }
}
