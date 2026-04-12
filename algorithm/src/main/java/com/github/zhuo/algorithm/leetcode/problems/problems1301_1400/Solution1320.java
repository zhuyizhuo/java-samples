package com.github.zhuo.algorithm.leetcode.problems.problems1301_1400;

/**
 * 二指输入的的最小距离
 *
 * hard
 */
public class Solution1320 {

    private static final int[][] dis = new int[26][26];

    static {
        final int COLUMN = 6;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                dis[i][j] = Math.abs(i / COLUMN - j / COLUMN) + Math.abs(i % COLUMN - j % COLUMN);
            }
        }
    }

    /**
     * beats 100%
     */
    public int minimumDistance(String word) {
        char[] s = word.toCharArray();

        int[] f = new int[26];
        int[] nf = new int[26];

        for (int i = 0; i < s.length - 1; i++) {
            int x = s[i] - 'A';
            int y = s[i + 1] - 'A';
            for (int anotherFinger = 0; anotherFinger < 26; anotherFinger++) {
                nf[anotherFinger] = Math.min(f[anotherFinger] + dis[x][y], f[y] + dis[x][anotherFinger]);
            }
            int[] tmp = f;
            f = nf;
            nf = tmp;
        }

        int ans = Integer.MAX_VALUE;
        for (int res : f) {
            ans = Math.min(ans, res);
        }
        return ans;
    }
}