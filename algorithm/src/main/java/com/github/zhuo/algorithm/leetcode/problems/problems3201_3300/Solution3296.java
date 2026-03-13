package com.github.zhuo.algorithm.leetcode.problems.problems3201_3300;

/**
 * 移山所需的最少秒数
 *
 * 给你一个整数 mountainHeight 表示山的高度。
 *
 * 同时给你一个整数数组 workerTimes，表示工人们的工作时间（单位：秒）。
 *
 * 工人们需要 同时 进行工作以 降低 山的高度。对于工人 i :
 *
 * 山的高度降低 x，需要花费 workerTimes[i] + workerTimes[i] * 2 + ... + workerTimes[i] * x 秒。例如：
 * 山的高度降低 1，需要 workerTimes[i] 秒。
 * 山的高度降低 2，需要 workerTimes[i] + workerTimes[i] * 2 秒，依此类推。
 * 返回一个整数，表示工人们使山的高度降低到 0 所需的 最少 秒数。
 */
public class Solution3296 {

    /**
     * beats 93.94%
     */
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        int max = 0;
        for (int x : workerTimes)
            max = Math.max(max, x);

        int h = (mountainHeight-1) / workerTimes.length + 1;
        long left = 1, right = (long) max * h * (h + 1) / 2;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (check(mountainHeight, workerTimes, mid)) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }

    boolean check(int mountainHeight, int[] workerTimes, long time) {
        for (int x : workerTimes) {
            mountainHeight -= (int)(-1 + Math.sqrt(1 + 8 * time / x)) / 2;
            if (mountainHeight <= 0) return true;
        }
        return false;
    }
}