package com.github.zhuo.algorithm.leetcode.problems9;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-number/
 *
 * 思路：思路是将数字反转后与原数字对比，由于不知道原数字长度，
 * 并且直接将数字反转后可能出大于 Integer.MAX_VALUE
 * 考虑 将数字反转一半 与 剩下的一半对比。
 * 可处理特殊情况，例如负数一定非回文数  直接返回 false 即可。
 * 数字不能以0开头 所以不为0的数且末位是0的数字 一定不是回文数字
 */
public class PalindromeNumberBestPractise {

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    /**
     * 思路：思路是将数字反转后与原数字对比，由于不知道原数字长度，
     * 并且直接将数字反转后可能出大于 Integer.MAX_VALUE
     * 考虑 将数字反转一半 与 剩下的一半对比。
     * 可处理特殊情况，例如负数一定非回文数  直接返回 false 即可。
     * 数字不能以0开头 所以不为0的数且末位是0的数字 一定不是回文数字
     */
    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        if (x == 0){
            return true;
        }
        //数字不能以0开头 所以不为0的数且末位是0 一定不是回文数字
        if (x % 10 == 0){
            return false;
        }
        int reverse = 0;
        //不断将 x 末位数字累加至 reverse，并且将 x = x/10,
//        如果 x <= reverse 说明已经反转了一半或一半以上，结束循环，
//        判断反转的一半和剩下的一半是否相等
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            if (reverse == x){
                return true;
            }
            x /= 10;
        }
        return reverse == x;
    }

}
