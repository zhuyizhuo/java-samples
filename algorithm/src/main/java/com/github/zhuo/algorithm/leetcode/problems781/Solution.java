package com.github.zhuo.algorithm.leetcode.problems781;

public class Solution {

    /**
     * 最终优化版，直接在循环中统计总数
     *
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 37.5 MB , 在所有 Java 提交中击败了 95.83% 的用户
     */
    public int numRabbits(int[] answers) {
        int[] rabbitMap = new int[1000];
        int total = 0;
        for (int i = 0; i < answers.length; i++) {
            if (rabbitMap[answers[i]] == 0 || rabbitMap[answers[i]] > answers[i]){
                rabbitMap[answers[i]] = 1;
                total += answers[i] + 1;
            } else {
                rabbitMap[answers[i]] += 1;
            }
        }
        return total;
    }
}
