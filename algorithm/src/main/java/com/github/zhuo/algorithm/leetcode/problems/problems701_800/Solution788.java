package com.github.zhuo.algorithm.leetcode.problems.problems701_800;

/**
 * 旋转数字
 *
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 *
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 *
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 */
public class Solution788 {

    /**
     * beats 100%
     */
    public int rotatedDigits(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Integer[][][] memo = new Integer[digits.length][2][2];
        return dfs(0, 1, 0, digits, memo);
    }

    private int dfs(int pos, int tight, int changed, char[] digits, Integer[][][] memo) {
        if (pos == digits.length) {
            return changed == 1 ? 1 : 0;
        }

        if (memo[pos][tight][changed] != null) {
            return memo[pos][tight][changed];
        }

        int limit = tight == 1 ? digits[pos] - '0' : 9;
        int count = 0;

        for (int d = 0; d <= limit; d++) {
            if (d == 3 || d == 4 || d == 7) {
                continue;
            }

            int nextTight = tight == 1 && d == limit ? 1 : 0;
            int nextChanged = changed;

            if (d == 2 || d == 5 || d == 6 || d == 9) {
                nextChanged = 1;
            }

            count += dfs(pos + 1, nextTight, nextChanged, digits, memo);
        }

        memo[pos][tight][changed] = count;
        return count;
    }
}