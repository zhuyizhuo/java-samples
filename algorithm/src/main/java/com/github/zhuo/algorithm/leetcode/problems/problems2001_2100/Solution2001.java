package com.github.zhuo.algorithm.leetcode.problems.problems2001_2100;

/**
 * 用一个下标从 0 开始的二维整数数组 rectangles 来表示 n 个矩形，其中 rectangles[i] = [widthi, heighti] 表示第 i 个矩形的宽度和高度。
 *
 * 如果两个矩形 i 和 j（i < j）的宽高比相同，则认为这两个矩形 可互换 。更规范的说法是，两个矩形满足 widthi/heighti == widthj/heightj（使用实数除法而非整数除法），则认为这两个矩形 可互换 。
 *
 * 计算并返回 rectangles 中有多少对 可互换 矩形。
 */
public class Solution2001 {

    private static final long N = 100000;

    /**
     * beats 100%
     */
    public long interchangeableRectangles(int[][] rectangles) {
        Node[] table = initial(rectangles.length);
        long answer = 0;
        for (int[] rectangle : rectangles) {
            int w = rectangle[0];
            int h = rectangle[1];
            answer += incr(table, (double) w / h);
        }
        return answer;
    }

    // 初始化哈希表，容量为大于 capacity 的最小 2 的幂
    private Node[] initial(int capacity) {
        int mask = capacity;
        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        mask |= mask >> 16;
        return new Node[mask + 1];
    }

    // 将哈希表 table 中 key 对应的值 +1
    private int incr(Node[] table, double key) {
        int hash = Double.hashCode(key) & table.length - 1;
        Node parent = null;
        Node node = table[hash];
        while (node != null) {
            if (node.key == key) {
                return node.val++;
            }
            parent = node;
            if (node.key > key) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if (parent == null) {
            table[hash] = new Node(key, 1);
        } else if (parent.key > key) {
            parent.left = new Node(key, 1);
        } else {
            parent.right = new Node(key, 1);
        }
        return 0;
    }

    private static class Node {
        private final double key;
        private int val;
        private Node left;
        private Node right;

        private Node(double key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
