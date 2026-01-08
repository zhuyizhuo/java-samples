package com.github.zhuo.algorithm.leetcode.problems.problems201_300;

/**
 * https://leetcode-cn.com/problems/power-of-two/
 * 2 的幂
 * 难度 简单
 *
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 如果存在一个整数 x 使得 n == 2^x ，则认为 n 是 2 的幂次方。
 *
 */
public class Solution231 {

    public static void main(String[] args) {
        System.out.println(isSolution231(1));
        System.out.println(isSolution231(16));
        System.out.println(isSolution231(3));
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 35.5 MB , 在所有 Java 提交中击败了 51.27% 的用户
     */
    public static boolean isSolution231(int n) {
        if (n == 0){
            return false;
        }
        if (n == 1){
            return true;
        }
        while (n != 0){
            if (n%2 == 0){
                n = n/2;
            } else {
                return false;
            }
            if (n == 1){
                return true;
            }
        }
        return true;
    }
}

/**
 * 思路：一个数 n 是 2 的幂，当且仅当 n 是正整数，并且 n 的二进制表示中仅包含 1 个 1。
 */
class Solution {

    /**
     * 位运算的两种技巧
     * 该位运算技巧可以直接将 n 二进制表示的最低位 1 移除
     */
    public boolean isSolution231(int n) {
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
