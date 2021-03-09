package com.github.zhuo.algorithm.leetcode.problems1784;

/**
 * https://leetcode-cn.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 * 检查二进制字符串字段
 * 难度 简单
 *
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * 如果 s 最多包含 一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s[i] 为 '0' 或 '1'
 * s[0] 为 '1'
 */
public class CheckOnesSegment {

    public static void main(String[] args) {
        System.out.println(checkOnesSegment("1001"));
        System.out.println(checkOnesSegment("1"));
        System.out.println(checkOnesSegment("110"));
        System.out.println(checkOnesSegment("11100"));
        System.out.println(checkOnesSegment("101100"));
        System.out.println(checkOnesSegment("1011100"));
        System.out.println(checkOnesSegment("10101101"));
    }

    public static boolean checkOnesSegment(String s) {
        char[] chars = s.toCharArray();
        boolean check = false;
        boolean lastIsOne = true;
        for (int i = 1; i < chars.length; i++) {
            //上一个不是1 当前是1 返回false
            if (!lastIsOne && chars[i] == '1'){
                return false;
            }
            if (chars[i] == '0') {
                lastIsOne = false;
            }
        }
        return true;
    }

    public static boolean checkOnesSegment1(String s) {
        return s.split("0+").length < 2;
    }
}
