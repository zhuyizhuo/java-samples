package com.github.zhuo.algorithm.leetcode.problems1_100.problems12;

/**
 * https://leetcode.com/problems/integer-to-roman/
 *
 * 整数转罗马数字
 */
public class IntegerToRomanBestPractice {

    static String[] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static int[] ints = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static void main(String[] args) {
//        System.out.println(intToRoman(1994).equals("MCMXCIV"));
//        System.out.println(intToRoman(58).equals("LVIII"));
//        System.out.println(intToRoman(9).equals("IX"));
//        System.out.println(intToRoman(4).equals("IV"));
//        System.out.println(intToRoman(3).equals("III"));
        System.out.println(intToRoman(20).equals("XX"));
    }

    /**
     * 初步思路就是每位比对
     */
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (num!=0){
            for (int i = start,len=ints.length; i < len; i++) {
                if (num >= ints[i]){
                    num -= ints[i];
                    sb.append(roman[i]);
                    break;
                } else {
                    start = i;
                }
            }
        }
        return sb.toString();
    }

}
