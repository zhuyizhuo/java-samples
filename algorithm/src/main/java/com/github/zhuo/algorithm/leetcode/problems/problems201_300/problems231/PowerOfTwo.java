package com.github.zhuo.algorithm.leetcode.problems.problems201_300.problems231;

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
public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(3));
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 35.5 MB , 在所有 Java 提交中击败了 51.27% 的用户
     */
    public static boolean isPowerOfTwo(int n) {
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
