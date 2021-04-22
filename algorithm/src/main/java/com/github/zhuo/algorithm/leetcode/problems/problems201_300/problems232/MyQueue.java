package com.github.zhuo.algorithm.leetcode.problems.problems201_300.problems232;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * 用栈实现队列
 * 难度 简单
 * 
 * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗： 36.7 MB , 在所有 Java 提交中击败了 5.11% 的用户
 */
public class MyQueue {

    private Deque<Integer> deque;
    /** Initialize your data structure here. */
    public MyQueue() {
        deque = new LinkedList();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        deque.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return deque.pollLast();
    }

    /** Get the front element. */
    public int peek() {
        return deque.peekLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }
}
