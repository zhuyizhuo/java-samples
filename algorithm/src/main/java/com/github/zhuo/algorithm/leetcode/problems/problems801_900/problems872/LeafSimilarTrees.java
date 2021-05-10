package com.github.zhuo.algorithm.leetcode.problems.problems801_900.problems872;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 * 叶子相似的树
 * 难度 简单
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * 
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 *
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 *
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 *
 * 提示：
 *  给定的两棵树可能会有 1 到 200 个结点。
 *  给定的两棵树上的值介于 0 到 200 之间。
 *
 */
public class LeafSimilarTrees {

    public static void main(String[] args) {
//        System.out.println(leafSimilar(tree, tree1));
    }

    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户
     * 内存消耗： 35.9 MB , 在所有 Java 提交中击败了 95.73% 的用户
     */
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        dfs(root1, list);
        dfs(root2, list1);
        if (list.size() != list1.size()){
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).compareTo(list1.get(i)) != 0){
                return false;
            }
        }
        return true;
    }

    private static void dfs(TreeNode root1, List list) {
        if (root1 == null){
            return;
        }
        dfs(root1.left, list);
        if (root1.left == null && root1.right == null){
            list.add(root1.val);
        }
        dfs(root1.right, list);
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
