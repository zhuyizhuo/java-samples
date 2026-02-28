package com.github.zhuo.algorithm.leetcode.problems.problems101_200;

/**
 * 颠倒二进制位
 * easy
 *
 * 颠倒给定的 32 位有符号整数的二进制位。
 */
public class Solution190 {

    public static void main(String[] args) {
        String s = Integer.toBinaryString(5);
        System.out.println(s);
    }

    /**
     * beats 100%
     */
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }
}
