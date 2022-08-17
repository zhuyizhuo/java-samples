package com.github.zhuo.algorithm.leetcode.problems.problems1301_1400.problems1302;

import com.github.zhuo.algorithm.common.TreeNode;
import com.github.zhuo.algorithm.common.TreeNodeUtil;

/**
 * https://leetcode.cn/problems/deepest-leaves-sum/
 * 层数最深叶子节点的和
 *
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 *
 * 树中节点数目在范围 [1, 10^4] 之间。
 * 1 <= Node.val <= 100
 */
public class DeepestLeavesSum {

    public static void main(String[] args) {
        Object[] params = new Object[]{6,7,8,2,7,1,3,9,null,1,4,null,null,null,5};
        TreeNode treeNode = TreeNodeUtil.levelCreateBinaryTree(params);
        TreeNodeUtil.levelPrintBinaryTree(treeNode);
        deepestLeavesSum(treeNode);
    }



    public static int deepestLeavesSum(TreeNode root) {
        return 0;
    }

}
