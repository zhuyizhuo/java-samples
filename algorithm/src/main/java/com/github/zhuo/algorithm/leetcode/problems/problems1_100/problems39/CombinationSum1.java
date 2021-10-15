package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems39;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 *
 * 组合总和
 */
public class CombinationSum1 {

    public static void main(String[] args) {
        //TODO 待理解
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
    }

    /**
     * 输入：candidates = [2,3,5], target = 8,
     * 所求解集为：
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return null;
    }
}
