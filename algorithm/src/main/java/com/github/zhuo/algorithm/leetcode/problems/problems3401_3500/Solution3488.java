package com.github.zhuo.algorithm.leetcode.problems.problems3401_3500;

import java.util.ArrayList;
import java.util.List;

/**
 * 距离最小相等元素查询
 *
 * 给你一个 环形 数组 nums 和一个数组 queries 。
 *
 * 对于每个查询 i ，你需要找到以下内容：
 *
 * 数组 nums 中下标 queries[i] 处的元素与 任意 其他下标 j（满足 nums[j] == nums[queries[i]]）之间的 最小 距离。如果不存在这样的下标 j，则该查询的结果为 -1 。
 * 返回一个数组 answer，其大小与 queries 相同，其中 answer[i] 表示查询i的结果。
 */
public class Solution3488 {

    /**
     * beats 100%
     */
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int[] l = new int[n];
        int max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        int[] index = new int[max + 1];
        for (int i = -n; i < 0; i++) {
            index[nums[i + n]] = i;
        }
        for (int i = 0; i < n; i++) {
            l[i] = i - index[nums[i]];
            index[nums[i]] = i;
        }
        for (int i = n * 2 - 1; i >= n; i--) {
            index[nums[i - n]] = i;
        }
        for (int i = n - 1; i >= 0; i--) {
            l[i] = l[i] == n ? -1 : Math.min(l[i], index[nums[i]] - i);
            index[nums[i]] = i;
        }
        List<Integer> res = new ArrayList<>();
        for (int i : queries) {
            res.add(l[i]);
        }
        return res;
    }
}