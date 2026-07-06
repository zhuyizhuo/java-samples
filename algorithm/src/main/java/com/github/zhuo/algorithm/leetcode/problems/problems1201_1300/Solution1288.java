package com.github.zhuo.algorithm.leetcode.problems.problems1201_1300;

/**
 * 删除被覆盖区间
 */
public class Solution1288 {

    /**
     * beats 100%
     */
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        int ans = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && intervals[j][0] <= intervals[i][0] && intervals[i][1] <= intervals[j][1]) {
                    ans--;
                    break;
                }
            }
        }
        return ans;
    }
}