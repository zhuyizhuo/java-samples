package com.github.zhuo.algorithm.leetcode.problems.problems700_800.problems783;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 * 二叉搜索树节点最小距离
 * 难度 简单
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 */
public class MinimumDistanceBetweenBSTNodes {

    public static void main(String[] args) {
//        System.out.println(minDiffInBST());
    }

    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 26.90% 的用户
     * 内存消耗： 36.1 MB , 在所有 Java 提交中击败了 33.31% 的用户
     */
    public static int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        List<Integer> vals = new ArrayList<>();
        dfs(root, vals);
        Collections.sort(vals);
        for (int i = 1; i < vals.size(); i++) {
            min = Math.min(vals.get(i) - vals.get(i-1), min);
        }
        return min;
    }

    private static void dfs(TreeNode root, List<Integer> vals) {
        if (root == null){
            return;
        }
        dfs(root.left, vals);
        vals.add(root.val);
        dfs(root.right, vals);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
