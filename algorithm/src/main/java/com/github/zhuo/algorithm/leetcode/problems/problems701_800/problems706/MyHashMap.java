package com.github.zhuo.algorithm.leetcode.problems.problems701_800.problems706;

import java.util.Arrays;

/**
 * 最简单的处理
 * 执行用时： 61 ms , 在所有 Java 提交中击败了 9.03% 的用户
 * 内存消耗： 46.4 MB , 在所有 Java 提交中击败了 6.55% 的用户
 */
public class MyHashMap {

    private int[] map;
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.map = new int[1000001];
        Arrays.fill(map, -1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map[key] = -1;
    }
}
