package com.github.zhuo.algorithm.leetcode.problems.problems1301_1400;

import com.github.zhuo.algorithm.common.TreeNode;

/**
 * 给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
 *
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
 */
public class Solution1339 {

    private int sum = 0;
    private int best = 0;

    /**
     * beats 100%
     */
    public int maxProduct(TreeNode root) {
        dfs(root);
        dfs2(root);
        return (int)((long)best * (sum - best) % 1000000007);
    }

    private void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        sum += node.val;
        dfs(node.left);
        dfs(node.right);
    }

    private int dfs2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int cur = dfs2(node.left) + dfs2(node.right) + node.val;
        if (Math.abs(cur * 2 - sum) < Math.abs(best * 2 - sum)) {
            best = cur;
        }
        return cur;
    }
}