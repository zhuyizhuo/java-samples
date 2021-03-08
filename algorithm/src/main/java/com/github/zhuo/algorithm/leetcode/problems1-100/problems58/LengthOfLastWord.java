package com.github.zhuo.algorithm.leetcode.problems58;

/**
 * https://leetcode-cn.com/problems/length-of-last-word/
 *
 * 最后一个单词的长度
 * 难度: 简单
 *
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("nnbbb"));
    }

    /**
     *  " abc dcs"
     *  "abc  "
     *  "avc ds "
     *  " tre "
     *  普通思路  效率较低  从前向后找
     *  执行用时：2 ms , 在所有 Java 提交中击败了 11.96% 的用户
     */
    public static int lengthOfLastWord(String s) {
        int wordLength = 0;
        boolean reset = false;
        for (int i = 0,len = s.length(); i < len; i++) {
            if (s.charAt(i) == ' '){
                reset = true;
                continue;
            }
            if (reset) {
                wordLength = 0;
                reset = false;
            }
            wordLength ++;
        }
        return wordLength;
    }

}
