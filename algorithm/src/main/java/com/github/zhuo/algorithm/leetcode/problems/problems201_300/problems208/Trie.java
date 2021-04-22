package com.github.zhuo.algorithm.leetcode.problems.problems201_300.problems208;

import java.util.HashMap;
import java.util.Map;

/**
 * 执行用时： 255 ms , 在所有 Java 提交中击败了 5.04% 的用户
 * 内存消耗： 47.9 MB , 在所有 Java 提交中击败了 61.46% 的用户
 */
public class Trie {

    Map wordMap;
    Map prefixMap;
    /** Initialize your data structure here. */
    public Trie() {
        wordMap = new HashMap<>();
        prefixMap = new HashMap();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        wordMap.put(word, word);
        prefixMap.put(word, word);
        for (int i = word.length() - 1; i > 0; i--) {
            prefixMap.put(word.substring(0, i), 0);
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return wordMap.containsKey(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return prefixMap.containsKey(prefix);
    }

}
