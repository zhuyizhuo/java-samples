package com.github.zhuo.algorithm.leetcode.problems.problems2101_2200;

import com.github.zhuo.algorithm.common.TreeNode;

/**
 * 根据描述创建二叉树
 *
 * 给你一个二维整数数组 descriptions ，其中 descriptions[i] = [parenti, childi, isLefti] 表示 parenti 是 childi 在 二叉树 中的 父节点，二叉树中各节点的值 互不相同 。此外：
 *
 * 如果 isLefti == 1 ，那么 childi 就是 parenti 的左子节点。
 * 如果 isLefti == 0 ，那么 childi 就是 parenti 的右子节点。
 * 请你根据 descriptions 的描述来构造二叉树并返回其 根节点 。
 *
 * 测试用例会保证可以构造出 有效 的二叉树。
 */
public class Solution2196 {


    /**
     * beat 99.15%
     */
    public TreeNode createBinaryTree(int[][] descriptions) {
        TreeNode[] nodes = new TreeNode[100001];
        boolean[] existParent = new boolean[100001];
        for (int[] description : descriptions) {
            if (nodes[description[0]] == null) {
                nodes[description[0]] = new TreeNode(description[0]);
            }
            if (nodes[description[1]] == null) {
                nodes[description[1]] = new TreeNode(description[1]);
            }
            if (description[2] == 1) {
                nodes[description[0]].left = nodes[description[1]];
            } else {
                nodes[description[0]].right = nodes[description[1]];
            }
            existParent[description[1]] = true;
        }
        for (int i = 0; i < 100001; i++) {
            if (nodes[i] != null && !existParent[i]) {
                return nodes[i];
            }
        }
        return null;
    }
}