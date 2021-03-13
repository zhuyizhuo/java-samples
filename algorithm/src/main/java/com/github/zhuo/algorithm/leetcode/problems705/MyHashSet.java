package com.github.zhuo.algorithm.leetcode.problems705;

/**
 * 执行用时： 27 ms , 在所有 Java 提交中击败了 23.18% 的用户
 * 内存消耗： 47.3 MB , 在所有 Java 提交中击败了 5.09% 的用户
 */
public class MyHashSet {
    private int[] keys;
    /** Initialize your data structure here. */
    public MyHashSet() {
        keys = new int[1000001];
        keys[0] = -1;
    }

    public void add(int key) {
        keys[key] = key;
    }

    public void remove(int key) {
        keys[key] = -1;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return keys[key] == key;
    }
}
