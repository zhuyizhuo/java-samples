package com.github.zhuo.algorithm.leetcode.problems.problems601_700.problems655;

import com.github.zhuo.algorithm.common.TreeNode;
import com.github.zhuo.algorithm.common.TreeNodeUtil;

import java.util.List;

/**
 * https://leetcode.cn/problems/print-binary-tree/
 * 输出二叉树
 * 难度 中等
 * 题目详情参考链接
 */
public class PrintBinaryTree {

    public static void main(String[] args) {
        Object[] params = new Object[]{1,2};
        TreeNode treeNode = TreeNodeUtil.levelCreateBinaryTree(params);
        TreeNodeUtil.levelPrintBinaryTree(treeNode);
        printTree(treeNode);
    }

    public static List<List<String>> printTree(TreeNode root) {


        return null;
    }
}
