package com.github.zhuo.algorithm.leetcode.problems.problems601_700;

/**
 * https://leetcode-cn.com/problems/sum-of-square-numbers/
 * 平方数之和
 * 难度 中等
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 */
public class Solution633 {

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(3));
        System.out.println(judgeSquareSum(4));
        System.out.println(judgeSquareSum(2));
        System.out.println(judgeSquareSum(1));
        System.out.println("-----------------------");
        System.out.println(judgeSquareSum1(5));
        System.out.println(judgeSquareSum1(3));
        System.out.println(judgeSquareSum1(4));
        System.out.println(judgeSquareSum1(2));
        System.out.println(judgeSquareSum1(1));
        System.out.println(judgeSquareSum1(Integer.MAX_VALUE));
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

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 96.91% 的用户
     * 内存消耗： 35 MB , 在所有 Java 提交中击败了 94.28% 的用户
     */
    public static boolean judgeSquareSum1(int c) {
        int a = 0, b = (int)Math.sqrt(c);
        while (a <= b){
            int res = a * a + b * b;
            if(res == c){
                return true;
            }
            if (res > c){
                b--;
            } else {
                a++;
            }
        }
        return false;
    }
}
