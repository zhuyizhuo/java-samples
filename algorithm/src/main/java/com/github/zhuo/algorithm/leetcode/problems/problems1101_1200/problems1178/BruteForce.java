package com.github.zhuo.algorithm.leetcode.problems.problems1101_1200.problems1178;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BruteForce {

    /**
     * 暴力法
     *
     * 循环每个 puzzles，根据首字母取出对应的 words，没有则无子集。
     * 在 puzzle 中查找每个单词的每个字符，如果没查到，则该单词非当前 puzzle 的子集。
     * 如果都存在，则当前 words 为当前 puzzle 的子集
     *
     * 时间复杂度为 O(puzzles.length*words.length*max(words[i].size)*max(puzzles[i].length))
     *
     * 	超出时间限制
     */
    public static List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        int length = puzzles.length;
        List<Integer> resp = new ArrayList<>(length);
        int totalWord = words.length;
        Map<Character, List<char[]>> containsFirstLetterWord = new HashMap<>();
        // 循环每个字谜
        for (int i = 0; i < length; i++) {
            //每个 puzzle
            char[] chars = puzzles[i].toCharArray();
            char firstLetter = chars[0];
            //包含 puzzle 的首字母的单词集合
            List<char[]> wordList = containsFirstLetterWord.get(firstLetter);
            if (wordList == null) {
                for (int j = 0; j < totalWord; j++) {
                    if (words[j].indexOf(firstLetter) == -1) {
                        continue;
                    }
                    wordList = containsFirstLetterWord.get(firstLetter);
                    if (wordList == null){
                        ArrayList<char[]> list = new ArrayList<>();
                        list.add(words[j].toCharArray());
                        containsFirstLetterWord.put(firstLetter, list);
                    } else {
                        wordList.add(words[j].toCharArray());
                        containsFirstLetterWord.put(firstLetter, wordList);
                    }
                }
                wordList = containsFirstLetterWord.get(firstLetter);
            }
            if (wordList == null){
                resp.add(0);
                continue;
            }
            int count = 0;
            boolean isAnswer = true;
            for (int j = 0,len = wordList.size(); j < len; j++) {
                // 每个单词
                char[] word = wordList.get(j);
                for (int k = 0, size = word.length; k < size; k++) {
                    //如果字符在谜面中不存在 当前单词就不是答案
                    if (puzzles[i].indexOf(word[k]) == -1){
                        isAnswer = false;
                        break;
                    }
                }
                if (isAnswer){
                    count++;
                }
                isAnswer = true;
            }
            resp.add(count);
        }
        return resp;
    }
}
