package com.github.zhuo.algorithm.leetcode.problems.problems200_300.problems232;

public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }

}
