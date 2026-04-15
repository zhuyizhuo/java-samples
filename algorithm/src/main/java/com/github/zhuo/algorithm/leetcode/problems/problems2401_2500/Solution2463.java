package com.github.zhuo.algorithm.leetcode.problems.problems2401_2500;

import java.util.Arrays;
import java.util.List;

/**
 * 最小移动总距离
 * hard
 */
public class Solution2463 {

    /**
     * beats 100%
     */
    public long minimumTotalDistance(List<Integer> robotList, int[][] factory) {
        int[] robot = robotList.stream().mapToInt(i -> i).toArray();
        Arrays.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        int m = robot.length;
        long[] f = new long[m + 1];
        Arrays.fill(f, Long.MAX_VALUE / 2);
        f[0] = 0;

        int[] idxQ = new int[m + 1]; // 用两个数组模拟 ArrayDeque
        long[] valQ = new long[m + 1];

        for (int[] fac : factory) {
            int position = fac[0];
            int limit = fac[1];

            long disSum = 0;
            int head = 0;
            int tail = 0;
            idxQ[tail] = 0;
            valQ[tail] = 0;

            for (int j = 1; j <= m; j++) {
                disSum += Math.abs(robot[j - 1] - position);

                // 1. 入
                long v = f[j] - disSum;
                while (head <= tail && valQ[tail] >= v) {
                    tail--;
                }
                tail++;
                idxQ[tail] = j;
                valQ[tail] = v;

                // 2. 出
                while (idxQ[head] < j - limit) {
                    head++;
                }

                // 3. 队首为滑动窗口最小值
                f[j] = disSum + valQ[head];
            }
        }

        return f[m];
    }
}