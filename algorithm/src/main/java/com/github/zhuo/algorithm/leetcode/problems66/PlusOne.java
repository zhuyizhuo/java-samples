package com.github.zhuo.algorithm.leetcode.problems66;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/plus-one/
 *
 * 加一
 */
public class PlusOne {

    public static void main(String[] args) {
        System.out.println(plusOne(new int[]{9,9,9}));
    }

    public static int[] plusOne(int[] digits) {
        boolean carry = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            if (i == digits.length - 1){
                digit += 1;
            }
            if (carry){
                digit += 1;
            }
            if (digit >= 10){
                digits[i] = digit - 10;
                carry = true;
            } else {
                digits[i] = digit;
                carry = false;
            }
        }
        if (carry){
            int[] rtn = new int[digits.length + 1];
            rtn[0] = 1;
            System.arraycopy(digits, 0, rtn, 1, rtn.length - 1);
            return rtn;
        }
        return digits;
    }
}
