package com.github.zhuo.algorithm.leetcode.problems.problems701_800.problems705;

/**
 * https://leetcode-cn.com/problems/design-hashset/
 * 设计哈希集合
 * 难度 简单
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 *
 * 实现 MyHashSet 类：
 *
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 *
 * 提示：
 *
 * 0 <= key <= 10^6
 * 最多调用 10^4 次 add、remove 和 contains 。
 */
public class DesignHashSet {

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.contains(5));
        System.out.println(set.contains(3));
    }
}
