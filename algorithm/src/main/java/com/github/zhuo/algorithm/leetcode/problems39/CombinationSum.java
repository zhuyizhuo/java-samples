package com.github.zhuo.algorithm.leetcode.problems39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class CombinationSum {

    public static void main(String[] args) {
        //TODO
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
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> resp = new ArrayList<>();
        List<Integer> inner;
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < candidates.length; i++) {
            inner = new ArrayList<>();

            if (m.get(target - candidates[i]) == null){
                m.put(candidates[i], candidates[i]);
            } else {
                inner.add(candidates[i]);
                inner.add(m.get(target - candidates[i]));
            }

            if (candidates[i] == target){
                inner.add(candidates[i]);
            }

            if (target % candidates[i] == 0){
                for (int j = 0; j < target / candidates[i]; j++) {
                    inner.add(candidates[i]);
                }
            }
            resp.add(inner);
        }
        return resp;
    }
}
