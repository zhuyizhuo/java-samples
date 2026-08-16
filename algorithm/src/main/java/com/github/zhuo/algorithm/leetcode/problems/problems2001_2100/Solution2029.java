package com.github.zhuo.algorithm.leetcode.problems.problems2001_2100;

/**
 *  石子游戏 IX
 */
public class Solution2029 {
    /**
     * beats 100%
     */
    public boolean stoneGameIX(int[] stones) {
        int[] arr = new int[3];
        for (int stone : stones) {
            arr[stone%3]++;
        }

        if (arr[0]%2 == 0) {
            return arr[1]>=1 && arr[2]>=1;
        }
        return Math.abs(arr[1]-arr[2]) >= 3;
    }
}