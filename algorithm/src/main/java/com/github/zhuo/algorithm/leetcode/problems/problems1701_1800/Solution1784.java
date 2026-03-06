package com.github.zhuo.algorithm.leetcode.problems.problems1701_1800;

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
public class Solution1784 {

    public static void main(String[] args) {
        Solution1784 solution1784 = new Solution1784();
        System.out.println(solution1784.checkOnesSegment("1001"));
        System.out.println(solution1784.checkOnesSegment("1"));
        System.out.println(solution1784.checkOnesSegment("110"));
        System.out.println(solution1784.checkOnesSegment("11100"));
        System.out.println(solution1784.checkOnesSegment("101100"));
        System.out.println(solution1784.checkOnesSegment("1011100"));
        System.out.println(solution1784.checkOnesSegment("10101101"));
    }

    /**
     * beats 100%
     */
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }

    /**
     * beats 100%
     */
    public boolean checkOnesSegment0(String s) {
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

    public boolean checkOnesSegment1(String s) {
        return s.split("0+").length < 2;
    }
}
