package com.github.zhuo.algorithm.leetcode.problems1_100.problems13;

/**
 * https://leetcode.com/problems/roman-to-integer/
 *
 * 罗马数字转为 int
 *
 */
public class RomanToInteger {
    static String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static int[] ints = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

    public static int romanToInt(String s) {
        int sum = 0;
        int start = 0;
        for (int i = 0,len = s.length(); i < len; i++) {
            for (int j = start; j < roman.length; j++) {
                if (roman[j].length() == 1){
                    if (roman[j].equals(s.substring(i, i+1))){
                        sum += ints[j];
                        start = j;
                        break;
                    }
                } else {
                    if (i < len - 1 && roman[j].equals(s.substring(i, i+2))){
                        sum += ints[j];
                        start = j;
                        break;
                    }
                }
            }
        }
        return sum;
    }

}
