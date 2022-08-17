package com.github.zhuo.algorithm.leetcode.problems.problems201_300.problems231;

/**
 * 思路：一个数 n 是 2 的幂，当且仅当 n 是正整数，并且 n 的二进制表示中仅包含 1 个 1。
 */
public class Solution {

    /**
     * 位运算的两种技巧
     * 该位运算技巧可以直接将 n 二进制表示的最低位 1 移除
     */
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n-1)) == 0;
    }

    /**
     * 该位运算技巧可以直接获取 n 二进制表示的最低位的 1。
     * 由于负数是按照补码规则在计算机中存储的，-n 的二进制表示为 n 的二进制表示的每一位取反再加上 1
     */
    public boolean isPowerOfTwo1(int n) {
        return n > 0 && (n & -n) == n;
    }

}
