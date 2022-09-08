package com.github.zhuo.algorithm.leetcode.problems.problems501_600.problems557;

/**
 *  反转字符串中的单词 III
 *  https://leetcode.cn/problems/reverse-words-in-a-string-iii/
 *  难度 简单
 *  给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
//        String s1 = "God Ding";
        System.out.println(reverseWords(s));
    }

    /**
     * 执行用时： 6 ms , 在所有 Java 提交中击败了 53.77% 的用户
     * 内存消耗： 42 MB , 在所有 Java 提交中击败了 42.05% 的用户
     * 通过测试用例： 29 / 29
     */
    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            char[] chars = s1[i].toCharArray();
            for (int j = chars.length - 1; j >= 0; j--) {
                sb.append(chars[j]);
            }
            sb.append(" ");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }
}
