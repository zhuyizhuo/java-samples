package com.github.zhuo.algorithm.leetcode.problems424;

/**
 * https://leetcode-cn.com/problems/longest-repeating-character-replacement/
 *
 * 替换后的最长重复字符
 * 
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过 104。
 */
public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        //todo
//        System.out.println(characterReplacement("ABBB",2));
        System.out.println(characterReplacement("CABCACBBB",2));
        System.out.println(characterReplacement("ABBBAA",2));
    }

    /**
     * 思路：分析题意，可转换为如下表述
     *
     * 给定一个字符串,查找该字符串中最长重复字母的子串的长度,查找重复字母的子串时,有 K 次中断的机会。
     */
    public static int characterReplacement(String s, int k) {
        char last = s.charAt(0);
        int maxLength = 1;
        int currLength = 1;
        int broke = k;
        for (int i = 1, len = s.length(); i < len; i++) {
            char c = s.charAt(i);
            if (c == last) {
                //如果当前字符等于上一个字符，则当前长度增加
                currLength ++;
            } else if (broke > 0) {
                //如果当前字符不等于上一个字符,但是容错大于0，则容错减少1,当前长度增加
                broke --;
                currLength ++;
            } else {
                //如果当前字符不等于上一个字符，且容错等于0, 比对最大长度和当前长度
                maxLength = Math.max(currLength, maxLength);
                currLength = 1;
                last = c;
                broke = k;
            }
        }
        //如果容错大于0 且容错和当前最大长度之和小于等于目标字符串长度
        int max = Math.max(maxLength, currLength);
        if (broke > 0) {
            return broke + max > s.length() ? s.length() : broke + max;
        }
        return max;
    }


}