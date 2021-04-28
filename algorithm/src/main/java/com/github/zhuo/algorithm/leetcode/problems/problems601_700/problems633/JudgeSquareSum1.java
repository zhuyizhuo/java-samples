package com.github.zhuo.algorithm.leetcode.problems.problems601_700.problems633;

public class JudgeSquareSum1 {

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum(3));
        System.out.println(judgeSquareSum(4));
        System.out.println(judgeSquareSum(2));
        System.out.println(judgeSquareSum(1));
        System.out.println(judgeSquareSum(Integer.MAX_VALUE));
    }

    /**
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 96.91% 的用户
     * 内存消耗： 35 MB , 在所有 Java 提交中击败了 94.28% 的用户
     */
    public static boolean judgeSquareSum(int c) {
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
