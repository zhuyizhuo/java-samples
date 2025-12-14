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
        if (params.length == 0 || params[0] == null){
            return null;
        }
        TreeNode treeNode = new TreeNode((int)params[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        levelCreateBinaryTree(params, queue);
        return treeNode;
    }

    private static void levelCreateBinaryTree(Object[] params, Queue<TreeNode> queue) {
        int index = 1;
        while (!queue.isEmpty() && index < params.length){
            TreeNode poll = queue.poll();
            Object param = params[index];
            index++;
            if (param != null){
                poll.left = new TreeNode();
                poll.left.val = (int) param;
                queue.add(poll.left);
            }
            if (index >= params.length){
                break;
            }
            param = params[index];
            index++;
            if (param != null){
                poll.right = new TreeNode();
                poll.right.val = (int) param;
                queue.add(poll.right);
            }
        }
    }

    /**
     * 层数打印二叉树
     * @param treeNode
     */
    public static void levelPrintBinaryTree(TreeNode treeNode) {
        if(treeNode == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 当前层的节点数量
            
            // 打印当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                
                if (current != null) {
                    System.out.print(current.val + " ");
                    // 将左右子节点加入队列，即使它们是null
                    queue.add(current.left);
                    queue.add(current.right);
                } else {
                    System.out.print("null ");
                    // 空节点的左右子节点也是null，但我们仍然需要加入队列以保持层级结构
                    queue.add(null);
                    queue.add(null);
                }
            }
            
            System.out.println(); // 换行到下一层
            
            // 检查队列是否只包含null，如果是则退出循环
            boolean allNull = true;
            for (TreeNode node : queue) {
                if (node != null) {
                    allNull = false;
                    break;
                }
            }
            if (allNull) {
                break;
            }
        }
    }
}
