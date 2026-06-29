package com.github.zhuo.algorithm.leetcode.problems.problems1901_2000;

/**
 * 作为子字符串出现在单词中的字符串数目
 * easy
 */
public class Solution1967 {

    /**
     * beats 100%
     */
    public int numOfStrings(String[] patterns, String word) {
        int n=patterns.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(word.contains(patterns[i]))
            {
                count++;
            }
        }
        return count;
    }
}