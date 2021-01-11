package com.github.zhuo.algorithm.leetcode.problems8;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 */
public class StringToInteger {

    public static void main(String[] args) {
        //TODO
        System.out.println(myAtoi("124 asdfaf"));
    }

    public static int myAtoi(String s) {
        String trim = s.trim();
        char c = trim.charAt(0);
        if ('+' == c || '-' == c || Character.isDigit(c)){
            StringBuilder sb = new StringBuilder(c);
            for (int i = 1; i < trim.length(); i++) {
                char c1 = trim.charAt(i);
                if (Character.isDigit(c1)){
                    sb.append(c1);
                } else {
                    break;
                }
            }
        }
        return 0;
    }
}
