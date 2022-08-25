package com.github.zhuo.algorithm.leetcode.problems.problems701_800.problems706;

import java.util.Arrays;

/**
 */
public class MyHashMap1 {

    private int[] map;
    /** Initialize your data structure here. */
    public MyHashMap1() {
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