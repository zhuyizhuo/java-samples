package com.github.zhuo.algorithm.leetcode.problems.problems701_800;

/**
 * 寻找比目标字母大的最小字母
 *
 * 给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target。letters 里至少有两个不同的字符。
 *
 * 返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符。
 */
public class Solution744 {

    /**
     * beats 100%
     */
    public char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        char nextGreater = letters[0];
        for (int i = 0; i < length; i++) {
            if (letters[i] > target) {
                nextGreater = letters[i];
                break;
            }
        }
        return nextGreater;
    }
}