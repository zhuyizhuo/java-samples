package com.github.zhuo.algorithm.leetcode.problems.problems3001_3100;

import java.util.Arrays;

/**
 * 输入单词需要的最少按键次数 II
 */
public class Solution3016 {

    /**
     * beats 99.71%
     */
    public int minimumPushes(String word) {
        int[] freqs = new int[26];
        for (int i = 0; i < word.length(); i++) {
            freqs[word.charAt(i) - 'a']++;
        }
        Arrays.sort(freqs);
        int appear = 0;
        int result = 0;
        for (int ind = 25; ind >= 0; ind--) {
            if (freqs[ind] == 0) {
                continue;
            }
            // 8 buttons, step with group size 8
            result += freqs[ind] * (appear/8 + 1);
            appear++;
        }
        return result;
    }
}