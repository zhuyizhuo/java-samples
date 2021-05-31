package com.github.zhuo.algorithm.leetcode.problems.problems301_400.problems342;

/**
 * https://leetcode-cn.com/problems/power-of-four/
 * 4的幂
 * 难度 简单
 *
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 */
public class PowerOfFour {

    /**
     * 判断是2的幂 并且除以3的余数为1
     * 
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 35.5 MB , 在所有 Java 提交中击败了 61.85% 的用户
     */
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n-1)) == 0 && n % 3 == 1;
    }

}
