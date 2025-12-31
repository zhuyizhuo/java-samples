package com.github.zhuo.algorithm.leetcode.problems.problems1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-number/
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class Solution9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(1001));
    }

    /**
     * 思路是将数字反转后与原数字对比，由于不知道原数字长度，
     * 所以将数字及倍数追加到两个 list 中 最后通过循环 list 叠加来得到最终的反转数字
     *
     * 由于使用了额外的空间及循环，本解法效率较低
     */
    public static boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }
        if (x == 0){
            return true;
        }
        long j = 1;
        List<Integer> list = new ArrayList();
        List<Long> list1 = new ArrayList();
        int tmp = x;
        while (tmp%10 != 0 || tmp > 0) {
            list.add(tmp % 10);
            j *= 10;
            list1.add(j);
            tmp /= 10;
        }
        int size = list.size();
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum += list.get(i) * list1.get(size-1-i)/10;
        }
        if (sum > Integer.MAX_VALUE){
            return false;
        }
        return (int)sum == x;
    }


    /**
     * 思路：思路是将数字反转后与原数字对比，由于不知道原数字长度，
     * 并且直接将数字反转后可能出大于 Integer.MAX_VALUE
     * 考虑 将数字反转一半 与 剩下的一半对比。
     * 可处理特殊情况，例如负数一定非回文数  直接返回 false 即可。
     * 数字不能以0开头 所以不为0的数且末位是0的数字 一定不是回文数字
     */
    public static boolean isPalindrome1(int x) {
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
