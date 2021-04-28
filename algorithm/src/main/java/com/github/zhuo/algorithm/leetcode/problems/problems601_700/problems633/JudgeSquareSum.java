package com.github.zhuo.algorithm.leetcode.problems.problems601_700.problems633;

/**
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 * 平方数之和
 * 难度 中等
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 */
public class JudgeSquareSum {

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(3));
        System.out.println(judgeSquareSum(4));
        System.out.println(judgeSquareSum(2));
        System.out.println(judgeSquareSum(1));
    }

    /**
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 18.46% 的用户
     * 内存消耗： 35.3 MB , 在所有 Java 提交中击败了 44.98% 的用户
     */
    public static boolean judgeSquareSum(int c) {
        int max = (int)Math.sqrt(c);
        for (int i = 0; i <= max; i++) {
            int i1 = (int)Math.sqrt(c - i * i);
            if (i1 * i1 + i * i == c){
                return true;
            }
        }
        return false;
    }
}
