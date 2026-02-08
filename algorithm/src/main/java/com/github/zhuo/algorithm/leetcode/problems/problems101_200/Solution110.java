package com.github.zhuo.algorithm.leetcode.problems.problems101_200;

/**
 * 平衡二叉树
 * easy
 *
 * 给定一个二叉树，判断它是否是 平衡二叉树
 */
public class Solution110 {

    /**
     * beats 100%
     */
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if (left == -1) return -1;
        int right = recur(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
