package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/number-of-different-integers-in-a-string/
 * 字符串中不同整数的数目
 * 难度 简单
 * 
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 *
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数为（相邻彼此至少有一个空格隔开）："123"、"34"、"8" 和 "34" 。
 *
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 *
 * 只有当两个整数的 不含前导零 的十进制表示不同， 才认为这两个整数也不同。
 *
 * 提示：
 *
 * 1 <= word.length <= 1000
 * word 由数字和小写英文字母组成
 */
public class Solution1805 {

    public static void main(String[] args) {
        System.out.println(numDifferentIntegers("a123bc34d8ef34"));
        System.out.println(numDifferentIntegers("leet1234code234"));
        System.out.println(numDifferentIntegers("a1b01c001"));
        System.out.println(numDifferentIntegers("167278959591294"));
        System.out.println(numDifferentIntegers("035985750011523523129774573439111590559325"));
        System.out.println(numDifferentIntegers("0a0"));
    }

    /**
     * 执行用时: 6 ms  超过 37%
     * 内存消耗: 37 MB
     */
    public static int numDifferentIntegers(String word) {
        String[] split = word.split("[a-z]+");
        Set<String> set = new HashSet<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].trim().length() > 0){
                int start = 0;
                while (start < split[i].length() - 1 && split[i].charAt(start) == '0'){
                    start++;
                }
                set.add(split[i].substring(start));
            }
        }
        return set.size();
    }
}
