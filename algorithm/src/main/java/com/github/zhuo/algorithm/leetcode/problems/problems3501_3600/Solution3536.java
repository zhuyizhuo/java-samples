package com.github.zhuo.algorithm.leetcode.problems.problems3501_3600;

/**
 * 两个数字的最大乘积
 */
public class Solution3536 {
    /**
     * beats 100%
     */
    public int maxProduct(int n) {
        int[] map = new int[10];
        while (n != 0) {
            map[n % 10]++;
            n /= 10;
        }
        int res = 1;
        int cnt = 2;
        for (int i = 9; i >= 0; i--) {
            while (map[i] > 0 && cnt > 0) {
                res *= i;
                map[i]--;
                cnt--;
            }
            if (cnt == 0) {
                break;
            }
        }
        return res;
    }
}