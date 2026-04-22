package com.github.zhuo.algorithm.leetcode.problems.problems2401_2500;

import java.util.ArrayList;
import java.util.List;

/**
 * 距离字典两次编辑以内的单词
 *
 * 给你两个字符串数组 queries 和 dictionary 。数组中所有单词都只包含小写英文字母，且长度都相同。
 *
 * 一次 编辑 中，你可以从 queries 中选择一个单词，将任意一个字母修改成任何其他字母。从 queries 中找到所有满足以下条件的字符串：不超过 两次编辑内，字符串与 dictionary 中某个字符串相同。
 *
 * 请你返回 queries 中的单词列表，这些单词距离 dictionary 中的单词 编辑次数 不超过 两次 。单词返回的顺序需要与 queries 中原本顺序相同。
 */
public class Solution2452 {

    /**
     * beats 100%
     */
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<String>();
        for (String query : queries) {
            if (isTwoEdit(query, dictionary)) {
                list.add(query);
            }
        }
        return list;
    }

    public boolean isTwoEdit(String query, String[] dictionary) {
        int n = query.length();
        for (String word : dictionary) {
            int edit = 0;
            for (int i = 0; i < n && edit <= 2; i++) {
                if (query.charAt(i) != word.charAt(i)) {
                    edit++;
                }
            }
            if (edit <= 2) {
                return true;
            }
        }
        return false;
    }
}