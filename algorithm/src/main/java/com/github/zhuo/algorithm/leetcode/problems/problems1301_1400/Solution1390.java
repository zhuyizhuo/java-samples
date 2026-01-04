package com.github.zhuo.algorithm.leetcode.problems.problems1301_1400;

/**
 * beats 100%
 */
public class Solution1390 {
    static int[] partAns = new int[100001];
    static int[] factors = new int[100001];
    static boolean initialized = false;

    private static void _init() {
        if (!initialized) {
            initialized = true;
            for (int i = 1; i < 100001; i++) {
                for (int j = i; j < 100001; j += i) {
                    factors[j]++;
                    partAns[j] += i;
                }
            }
        }
    }


    public int sumFourDivisors(int[] nums) {
        _init();
        int ans = 0;
        for (int num : nums) {
            if (factors[num] == 4) {
                ans += partAns[num];
            }
        }

        return ans;
    }

}
