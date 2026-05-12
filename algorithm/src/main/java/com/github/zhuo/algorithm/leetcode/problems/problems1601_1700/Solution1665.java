package com.github.zhuo.algorithm.leetcode.problems.problems1601_1700;

import java.util.Arrays;

/**
 * 完成所有任务的最少初始能量
 * hard
 */
public class Solution1665 {

    /**
     * beats 100%
     */
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int energy = 0;
        int curr = 0;

        for (int[] task : tasks) {
            if (curr < task[1]) {
                energy += task[1] - curr;
                curr = task[1];
            }

            curr -= task[0];
        }

        return energy;
    }
}