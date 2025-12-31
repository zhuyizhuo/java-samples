package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/subsets/
 * 子集
 * 难度 中等
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 提示：
 *   1 <= nums.length <= 10
 *   -10 <= nums[i] <= 10
 *   nums 中的所有元素 互不相同
 */
public class Solution78 {

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 38.6 MB , 在所有 Java 提交中击败了 76.65% 的用户
     */
    public static List<List<Integer>> subsets(int[] nums) {
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
            inner.add(nums[j]);
            dfs(nums, resp, inner, j + 1);
            inner.remove(inner.size() -  1);
        }
    }
}
