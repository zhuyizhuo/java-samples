package com.github.zhuo.algorithm.leetcode.problems173;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 执行用时： 22 ms , 在所有 Java 提交中击败了 95.60% 的用户
 * 内存消耗： 41.8 MB , 在所有 Java 提交中击败了 91.24% 的用户
 */
public class BSTIterator {

    Queue<Integer> tree = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        getVal(root);
    }

    private void getVal(TreeNode root) {
        if (root == null){
            return;
        } else {
            getVal(root.left);
        }
        tree.add(root.val);
        getVal(root.right);
    }

    public int next() {
        return tree.poll();
    }

    public boolean hasNext() {
        return tree.size() > 0;
    }
}
