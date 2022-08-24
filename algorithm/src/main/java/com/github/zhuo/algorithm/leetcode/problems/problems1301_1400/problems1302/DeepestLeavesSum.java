package com.github.zhuo.algorithm.leetcode.problems.problems1301_1400.problems1302;

import com.github.zhuo.algorithm.common.TreeNode;
import com.github.zhuo.algorithm.common.TreeNodeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        // 15
        Object[] params = new Object[]{1,2,3,4,5,null,6,7,null,null,null,null,8};
        // 19
//        Object[] params = new Object[]{6,7,8,2,7,1,3,9,null,1,4,null,null,null,5};
        // 72
//        Object[] params = new Object[]{61,13,46,null,null,null,56,72};
        // 21
//        Object[] params = new Object[]{4,90,15,92,42,73,14,90,81,97,20,29,50,87,54,6,34,2,18,63,6,94,90,49,2,11,53,49,26,30,91,39,83,26,64,87,96,13,25,null,null,96,null,44,58,24,2,6,15,8,5,16,13,74,76,18,21,73,64,82,83,20,85,96,58,36,88,null,null,38,94,51,61,null,1,64,67,90,null,76,null,7,64,17,83,42,33,null,17,8,52,43,null,null,null,55,49,43,44,46,33,2,9,null,null,null,95,null,45,null,68,71,16,6,20,null,24,97,null,82,2,48,31,null,89,43,null,82,null,72,null,40,10,null,85,null,41,null,null,11,null,null,36,41,41,null,null,5,98,12,11,9,46,92,46,24,96,60,16,null,58,22,43,36,39,null,59,52,null,28,39,65,80,15,null,94,3,25,11,null,48,2,100,null,null,68,82,null,null,65,54,37,60,3,87,25,88,null,null,44,42,49,75,29,38,64,20,67,null,null,39,null,58,null,null,77,null,82,21,null,98,90,null,null,null,null,3,48,null,null,null,null,38,null,null,6,null,68,7,90,44,11,10,99,35,62,62,16,null,10,33,null,null,null,null,null,null,1,null,87,null,12,13,26,54,61,54,null,null,null,null,null,36,null,29,20,14,70,83,null,null,null,null,null,26,null,null,null,null,58,null,78,5,null,82,11,11,null,17,12,67,50,null,21,null,null,null,null,90,null,48,24,47,29,80,81,91,12,78,28,null,null,null,19,88,84,79,null,78,null,null,null,null,96,87,null,null,50,66,null,null,null,null,null,null,79,null,null,null,null,null,77,null,null,null,61,15,null,null,null,56,8,77,91,88,16,null,39,72,null,null,null,27,64,null,62,null,78,35,87,44,null,83,null,27,6,null,79,null,91,78,null,null,54,67,null,62,null,null,null,69,73,59,22,27,9,99,null,null,null,null,2,null,null,null,73,20,null,36,95,64,null,null,77,31,25,35,null,56,null,90,null,55,5,null,38,89,null,null,null,null,47,16,1,36,31,23,null,67,43,87,22,54,51,null,null,null,null,2,80,null,71,65,null,null,null,null,null,null,null,87,null,null,null,null,null,null,15,null,null,null,43,52,40,18,null,10,25,93,null,null,null,5,46,84,12,null,54,51,null,72,null,null,null,87,33,22,null,20,84,null,85,null,null,null,null,null,null,22,63,63,51,70,58,null,null,null,null,null,null,null,90,null,50,80,51,null,6,null,69,32,null,67,21,87,null,null,68,null,null,null,null,null,null,null,null,48,null,null,null,null,null,15,null,94,56,17,6,null,null,90,55,null,null,null,null,78,29,null,null,null,null,null,76,72,82,null,null,63,13,46,11,null,null,64,43,34,null,null,84,null,38,67,null,null,6,52,31,null,null,null,null,null,null,null,28,null,98,95,11,null,null,null,null,null,null,9,null,null,null,13,61,null,3,55,null,null,null,null,77,null,1,null,null,70,42,null,null,null,null,null,null,null,null,null,null,null,null,23,86,26,null,null,73,14,null,51,91,59,null,null,null,null,8,86,null,null,null,null,null,null,null,null,8,27,null,null,null,null,92,null,5,null,null,59,null,null,null,88,15,null,75,null,null,null,null,null,null,null,null,null,null,null,null,null,null,62,92,5,90,null,null,6,null,43,null,null,null,null,null,19,null,null,null,null,null,null,13,null,null,70,77,null,null,null,62,null,100,null,null,null,null,null,33,null,82,17,null,null,84,null,28,75,null,null,null,40,null,null,null,null,null,null,null,null,69,75,87,44,55,null,null,73,null,null,null,16,null,null,null,40,75,51,null,null,null,null,27,null,null,95,null,25,null,null,null,null,38,49,null,null,null,null,1,null,null,null,null,null,null,null,92,92,null,null,null,null,61,null,null,null,null,null,null,null,null,null,49,null,74,91,20,45,70,58,null,null,null,null,null,null,null,null,null,87,null,84,null,null,76,null,null,null,null,null,null,null,null,null,null,null,null,null,null,85,null,null,58,null,39,9,null,29,54,null,92,72,null,null,null,null,19,null,null,null,null,null,68,null,94,null,97,55,47,29,null,null,23,null,null,13,null,null,29,null,null,null,68,4,15,25,null,46,null,3,6,76,null,null,74,null,20,9,57,27,34,68,null,null,88,null,null,null,null,null,null,21,null,null,null,null,null,null,19,87,null,null,null,null,null,5,null,null,null,null,null,48,97,81,82,84,34,null,null,null,null,79,null,null,3,null,null,78,34,null,null,null,26,null,null,73,null,null,78,97,21};

        TreeNode treeNode = TreeNodeUtil.levelCreateBinaryTree(params);
//        TreeNodeUtil.levelPrintBinaryTree(treeNode);
        int i = deepestLeavesSum(treeNode);
        System.out.println("求和:" + i);
    }


    /**
     * 执行用时： 13 ms , 在所有 Java 提交中击败了 6.19% 的用户
     * 内存消耗： 43.3 MB , 在所有 Java 提交中击败了 92.75% 的用户
     * 通过测试用例： 39 / 39
     */
    public static int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 层数
        int level = 0;
        // 每层已处理的有效节点数量
        int count = 0;
        // 每层原本的总节点数量
        double total = 1;
        // 当前节点空节点总数
        int currentLineNullCount = 0;
        // 上层的空节点总数
        int lastLineNullCount = 0;
        List<Integer> list = new ArrayList<>();
        // 上一行数据
        List<Integer> lastLine = null;
        while (!queue.isEmpty()){
            if (total - currentLineNullCount == count){
                lastLine = list;
                list = new ArrayList<>();
                currentLineNullCount *= 2;
                if (lastLineNullCount > 0){
                    currentLineNullCount += lastLineNullCount * 2;
                    lastLineNullCount = 0;
                }
                count = 0;
                level++;
                total = Math.pow(2, level);
            }
            TreeNode poll = queue.poll();
            if (poll != null){
                list.add(poll.val);
                TreeNode left = poll.left;
                queue.add(left);
                TreeNode right = poll.right;
                queue.add(right);
            } else {
                lastLineNullCount++;
            }
            count++;
        }
        if (lastLine == null || lastLine.isEmpty()){

        } else {
            if (list.isEmpty()){
                list = lastLine;
            }
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }


}
