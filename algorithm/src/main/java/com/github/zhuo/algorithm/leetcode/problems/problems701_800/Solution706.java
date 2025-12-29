package com.github.zhuo.algorithm.leetcode.problems.problems701_800;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/design-hashmap/
 * 设计哈希映射
 * 难度 简单
 *
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 *
 * 实现 MyHashMap 类：
 *
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 *
 * 提示：
 *
 * 0 <= key, value <= 10^6
 * 最多调用 10^4 次 put、get 和 remove 方法
 */
public class Solution706 {
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(2,1);
        System.out.println(myHashMap.get(3));
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }

}

/**
 * 最简单的处理
 * 执行用时： 61 ms , 在所有 Java 提交中击败了 9.03% 的用户
 * 内存消耗： 46.4 MB , 在所有 Java 提交中击败了 6.55% 的用户
 */
class MyHashMap {

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

class MyHashMap1 {
    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int SIZE = 10_009;
    private Node[] map;

    private int hash(int key) {
        return key % SIZE;
    }

    private Node find(Node head, int key) {
        Node pre = head;
        Node cur = head.next;

        while (cur != null && cur.key != key) {
            pre = pre.next;
            cur = cur.next;
        }

        return pre;
    }

    public MyHashMap1() {
        map = new Node[SIZE];
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (map[index] == null) {
            map[index] = new Node(-1, -1);
        }

        Node pre = find(map[index], key);
        if (pre.next != null) {
            pre.next.value = value;
        } else {
            pre.next = new Node(key, value);
        }
    }

    public int get(int key) {
        int index = hash(key);
        if (map[index] == null) {
            return -1;
        }

        Node pre = find(map[index], key);
        return pre.next == null ? -1 : pre.next.value;
    }

    public void remove(int key) {
        int index = hash(key);
        if (map[index] == null) {
            return;
        }

        Node pre = find(map[index], key);
        if (pre.next != null) {
            pre.next = pre.next.next;
        }
    }
}
