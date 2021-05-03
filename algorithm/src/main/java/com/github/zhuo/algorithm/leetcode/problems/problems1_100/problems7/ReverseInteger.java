package com.github.zhuo.algorithm.leetcode.problems.problems1_100.problems7;


/**
 * https://leetcode.com/problems/reverse-integer/
 *
 * 整数反转
 * 难度 简单
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1]，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 *
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 *
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 * Example 4:
 *
 * Input: x = 0
 * Output: 0
 *
 *
 * 提示：
 *  -2^31 <= x <= 2^31 - 1
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(-1563847412));
    }

    /**
     * 转字符串反转解法
     * 执行用时: 4 ms
     */
    public static int reverse(int x) {
        if (x == Integer.MIN_VALUE){
            return 0;
        }
        int tmp = x;
        if (x < 0){
            //注意 Integer.MIN_VALUE Math.abs 函数返回原值
            tmp = Math.abs(x);
        }
        String reverse = String.valueOf(tmp);
        StringBuilder sb = new StringBuilder();
        for (int i = reverse.length() - 1; i >= 0; i--) {
            sb.append(reverse.charAt(i));
        }
        String s = sb.toString();
        long l = Long.parseLong(s);
        if (l > Integer.MAX_VALUE){
            return 0;
        }
        if (x < 0){
            return - Integer.parseInt(s);
        }
        return Integer.parseInt(s);
    }
}
