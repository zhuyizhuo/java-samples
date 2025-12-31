package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems39;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
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
public class CombinationSum {

    public static void main(String[] args) {
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
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<Integer>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        dfs(candidates, target, ans, combine, idx + 1);
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }
}

/**
 * beats 100%
 */
final class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return new MyList(candidates, target);
    }

    static final class MyList extends AbstractList<List<Integer>> {

        final int[] candidates;
        final int target;
        long[][] nextMap;
        int[][] sizeMap;
        long next;
        int size;
        boolean init;

        MyList(int[] candidates, int target) {
            this.candidates = candidates;
            this.target = target;
        }

        void init() {
            nextMap = new long[target + 1][];
            sizeMap = new int[target + 1][];
            for (int i = target; i > 0; i--) {
                nextMap[i] = new long[candidates.length];
                sizeMap[i] = new int[candidates.length];
                Arrays.fill(nextMap[i], -1);
            }
            for (int start = 0; start < candidates.length; start++) {
                int startNext = find(target, start);
                if (startNext > 0) {
                    next |= 1L << start;
                    size += startNext;
                }
            }
        }

        int find(int target, int start) {
            if (nextMap[target][start] != -1) return sizeMap[target][start];
            int newTarget = target - candidates[start];
            if (newTarget == 0) {
                nextMap[target][start] = -2;
                sizeMap[target][start] = 1;
                return 1;
            } else {
                nextMap[target][start] = 0;
                if (newTarget < 0) return 0;
                int size = 0;
                for (int nextStart = start; nextStart < candidates.length; nextStart++) {
                    int nextSize = find(newTarget, nextStart);
                    if (nextSize > 0) {
                        nextMap[target][start] |= 1L << nextStart;
                        size += nextSize;
                    }
                }
                sizeMap[target][start] = size;
                return size;
            }
        }

        @Override
        public List<Integer> get(int index) {
            if (!init) init();
            List<Integer> res = new ArrayList<>();
            long curNext = next;
            int curTarget = target;
            do {
                int j = -1;
                for (int i = 0; i < candidates.length; i++) {
                    if ((curNext & (1L << i)) == 0) continue;
                    int curIndex = index - sizeMap[curTarget][i];
                    j = i;
                    if (curIndex < 0) break;
                    index = curIndex;
                }
                res.add(candidates[j]);
                curNext = nextMap[curTarget][j];
                if (curNext == -2) break;
                curTarget -= candidates[j];
            } while (true);
            return res;
        }

        @Override
        public int size() {
            if (!init) init();
            return size;
        }
    }
}
