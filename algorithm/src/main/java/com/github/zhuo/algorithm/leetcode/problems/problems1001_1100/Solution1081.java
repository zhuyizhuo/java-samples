package com.github.zhuo.algorithm.leetcode.problems.problems1001_1100;

/**
 * 不同字符的最小子序列
 */
public class Solution1081 {

    /**
     * beats 100%
     */
    public String smallestSubsequence(String s) {
        char[] letters = s.toCharArray();
        int[] letterCnt = new int[26];
        char[] stack = new char[letters.length];
        int exist = 0;
        int head = -1;
        for (char letter : letters)
            letterCnt[letter - 'a']++;
        for (char letter : letters) {
            int pos = letter - 'a';
            letterCnt[pos]--;
            if ((exist & (1 << pos)) != 0)
                continue;
            while (head >= 0 && stack[head] >= letter && letterCnt[stack[head] - 'a'] > 0) {
                exist &= (~(1 << (stack[head] - 'a')));
                head--;
            }
            stack[++head] = letter;
            exist |= (1 << pos);
        }

        return new String(stack, 0, head + 1);
    }
}