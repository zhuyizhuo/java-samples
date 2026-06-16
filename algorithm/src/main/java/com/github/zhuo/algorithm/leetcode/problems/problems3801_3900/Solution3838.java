package com.github.zhuo.algorithm.leetcode.problems.problems3801_3900;

/**
 * 带权单词映射
 * easy
 */
public class Solution3838 {

    /**
     * beats 100%
     */
    public String mapWordWeights(String[] words, int[] weights) {
        int n = words.length;
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            // 单词权重
            int w = 0;
            String item = words[i];
            for (int j = item.length() - 1; j >= 0; j--) {
                w += weights[item.charAt(j) - 'a'];
            }
            // 取模
            arr[i] = (char)('z' - (w % 26));
        }
        return new String(arr);
    }
}