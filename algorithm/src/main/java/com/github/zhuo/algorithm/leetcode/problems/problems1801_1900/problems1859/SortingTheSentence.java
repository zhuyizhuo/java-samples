package com.github.zhuo.algorithm.leetcode.problems.problems1801_1900.problems1859;

/**
 * https://leetcode-cn.com/problems/sorting-the-sentence/
 * 将句子排序
 * 难度 简单
 *
 * 一个 句子 指的是一个序列的单词用单个空格连接起来，且开头和结尾没有任何空格。每个单词都只包含小写或大写英文字母。
 *
 * 我们可以给一个句子添加 从 1 开始的单词位置索引 ，并且将句子中所有单词 打乱顺序 。
 *
 * 比方说，句子 "This is a sentence" 可以被打乱顺序得到 "sentence4 a3 is2 This1" 或者 "is2 sentence4 This1 a3" 。
 * 给你一个 打乱顺序 的句子 s ，它包含的单词不超过 9 个，请你重新构造并得到原本顺序的句子。
 *
 * 提示：
 *
 * 2 <= s.length <= 200
 * s 只包含小写和大写英文字母、空格以及从 1 到 9 的数字。
 * s 中单词数目为 1 到 9 个。
 * s 中的单词由单个空格分隔。
 * s 不包含任何前导或者后缀空格。
 *
 */
public class SortingTheSentence {

    public static void main(String[] args) {
        System.out.println(sortSentence("Myself2 Me1 I4 and3"));
    }

    public static String sortSentence(String s) {
        String[] s1 = s.split(" ");
        String[] resp = new String[10];
        for (int i = 0; i < s1.length; i++) {
            String substring = s1[i].substring(0, s1[i].length() - 1);
            char c = s1[i].charAt(s1[i].length() - 1);
            resp[Character.getNumericValue(c)] = substring;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resp.length; i++) {
            if (resp[i] != null && !"".equals(resp[i])){
                sb.append(resp[i]).append(" ");
            }
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}
