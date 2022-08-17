package com.github.zhuo.algorithm.common;


import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeUtil {

    public static void main(String[] args) {
        Object[] params = new Object[]{1,2,3,4,5,null,6,7,null,null,null,null,8};
        TreeNode node = levelCreateBinaryTree(params);
        levelPrintBinaryTree(node);
    }

    /**
     * 层序创建二叉树  支持给定空节点
     * @param params 给定的数组
     * @return 二叉树头节点
     */
    public static TreeNode levelCreateBinaryTree(Object[] params) {
        TreeNode treeNode = new TreeNode();
        if (params.length == 0 || params[0] == null){
            return treeNode;
        }
        Queue<TreeNode> queue = new LinkedList();
        treeNode.val = (int)params[0];
        queue.add(treeNode);
        levelCreateBinaryTree(params, queue);
        return treeNode;
    }

    private static void levelCreateBinaryTree(Object[] params, Queue<TreeNode> queue) {
        int index = 1;
        while (!queue.isEmpty() && index < params.length){
            TreeNode poll = queue.poll();
            Object param = params[index++];
            if (param != null){
                poll.left = new TreeNode();
                poll.left.val = (int) param;
                queue.add(poll.left);
            }
            param = params[index++];
            if (param != null){
                poll.right = new TreeNode();
                poll.right.val = (int) param;
                queue.add(poll.right);
            }
        }
    }

    /**
     * 层数打印二叉树 TODO 如果有 null 值 则下一层数据换行打印有误
     * @param treeNode
     */
    public static void levelPrintBinaryTree(TreeNode treeNode) {
        if(treeNode == null || treeNode.val == 0){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        // 层数
        int level = 0;
        // 每层打印数
        double count = 0;
        // 每层应打印数
        double totalCount = 1;
        // 每层的空值数
        int nullCount = 0;
        // 每层应减少打印的数量
        int totalNullCount = 0;
        while (!queue.isEmpty()){
            if (totalCount - totalNullCount == count){
                System.out.println();
                // 下一层
                level ++;
                // 每层应打印数
                totalCount = Math.pow(2, level);
                // 本层打印数
                count = 0;
                // 如果有空值 则按层数2倍放大减少打印量
                totalNullCount *= 2;
                // 上一层有空数据 本层减少打印量
                if (nullCount > 0){
                    totalNullCount += Math.pow(2, nullCount);
                    nullCount = 0;
                }
            }
            TreeNode poll = queue.poll();
            if (poll != null){
                System.out.print(poll.val + " ");
                TreeNode left = poll.left;
                queue.add(left);
                TreeNode right = poll.right;
                queue.add(right);
            } else {
                System.out.print(" null ");
                nullCount++;
            }
            count++;
        }
    }
}
