package com.github.zhuo.algorithm.leetcode.problems1_100.problems7;


/**
 * https://leetcode.com/problems/reverse-integer/
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For this problem, assume that your function returns 0 when the reversed integer overflows.
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
 * Constraints:
 *
 * -2^31 <= x <= 2^31 - 1
 */
public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(-1563847412));
    }

    /**
     * 转字符串反转解法
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
