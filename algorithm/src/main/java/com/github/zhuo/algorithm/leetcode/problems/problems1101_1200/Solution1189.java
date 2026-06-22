package com.github.zhuo.algorithm.leetcode.problems.problems1101_1200;

/**
 * “气球” 的最大数量
 * easy
 */
public class Solution1189 {

    /**
     * beats 96.67%
     */
    public int maxNumberOfBalloons(String text) {
        final int[][] cache = new int[2][5];
        cache[0][0] = 97;  // a
        cache[0][1] = 98;  // b
        cache[0][2] = 108; // l
        cache[0][3] = 110; // n
        cache[0][4] = 111; // o

        // calc letter frequencies
        for (char ch : text.toCharArray()) {
            final int intValue = ch;
            for (int i = 0; i < 5; i++) {
                if (intValue == cache[0][i]) {
                    cache[1][i]++;
                    break;
                }
            }
        }

        // l & o meet twice
        cache[1][2] /= 2;
        cache[1][4] /= 2;

        // find the bottleneck
        int min = Integer.MAX_VALUE;
        for (int frequency: cache[1]) {
            min = Math.min(min, frequency);
        }

        return min;
    }
}